package com.code.project;

import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.UserInfoDO;
import com.code.project.biz.util.MD5Util;
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
public class TestUserLog {

    @Autowired
    UserInfoDAO userInfoDAO;


    @Test
    public void testInsert() {
        try {
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setUserName("username");
            userInfoDO.setPassWord(MD5Util.code("123"));
            userInfoDO.setReadOrignal(1);
            userInfoDO.setType(1);
            userInfoDO.setDeFog(1);
            userInfoDO.setEmail("123@email.com");
            userInfoDO.setRegisterCamera(2);
            userInfoDO.setReadDeFog(3);
            userInfoDAO.add(userInfoDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testUpdate() {
        try {
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setUserName("username");
            userInfoDO.setPassWord(MD5Util.code("12345"));
            userInfoDO.setReadOrignal(1);
            userInfoDO.setType(1);
            userInfoDO.setDeFog(1);
            userInfoDO.setEmail("12345@email.com");
            userInfoDO.setRegisterCamera(2);
            userInfoDO.setReadDeFog(3);
            userInfoDAO.update(userInfoDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuery() {
        try {
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setUserName("username");
            userInfoDO.setPassWord(MD5Util.code("12345"));
            userInfoDO.setReadOrignal(1);
            userInfoDO.setType(1);
            userInfoDO.setDeFog(1);
            userInfoDO.setEmail("12345@email.com");
            userInfoDO.setRegisterCamera(2);
            userInfoDO.setReadDeFog(3);
            List<UserInfoDO> list = userInfoDAO.select(userInfoDO);
            for (UserInfoDO i: list) {
                   System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
