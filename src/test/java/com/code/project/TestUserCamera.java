package com.code.project;

import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dataobject.CameraDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    CameraDAO cameraDAO;


    @Test
    public void testInsert() {
        try {
            CameraDO cameraDO = new CameraDO();
            cameraDO.setCameraIP("127.0.0.1");
            cameraDO.setCameraMaster("user");
            cameraDO.setCameraName("abc");
            cameraDO.setCameraStatus(1);
            cameraDAO.add(cameraDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testUpdate() {
        try {
            CameraDO cameraDO = new CameraDO();
            cameraDO.setCameraIP("127.0.0.11");
            cameraDO.setCameraMaster("user123");
            cameraDO.setCameraName("abc");
            cameraDO.setCameraStatus(1);
            cameraDAO.update(cameraDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuery() {
        try {
            CameraDO cameraDO = new CameraDO();
            cameraDO.setCameraIP("127.0.0.11");
            cameraDO.setCameraMaster("user123");
            cameraDO.setCameraName("abc");
            List<CameraDO> list = cameraDAO.select(cameraDO);
            for(CameraDO i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
