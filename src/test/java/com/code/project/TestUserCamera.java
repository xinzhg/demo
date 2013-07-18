package com.code.project;

import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.UserCameraDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserCameraDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-4
 * Time: 上午9:55
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:dao/datasource.xml","classpath:dao/springbeans-dao.xml"
})
public class TestUserCamera {

    @Autowired
    UserCameraDAO userCameraDAO;


    @Test
    public void testInsert() {
        try {
            UserCameraDO userCameraDO = new UserCameraDO();
            userCameraDO.setCameraName("cameraName");
            userCameraDO.setCameraId(12);
            userCameraDO.setCreateTime(new Date());
            userCameraDO.setUserName("username");
            userCameraDAO.add(userCameraDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testUpdate() {
        try {
            UserCameraDO userCameraDO = new UserCameraDO();
            userCameraDO.setCameraName("cameraName12");
            userCameraDO.setCameraId(122);
            userCameraDO.setCreateTime(new Date());
            userCameraDO.setUserName("username");
            userCameraDAO.update(userCameraDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuery() {
        try {
            UserCameraDO userCameraDO = new UserCameraDO();
            userCameraDO.setUserName("username");
            List<UserCameraDO> list = userCameraDAO.select(userCameraDO);
            for(UserCameraDO i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
