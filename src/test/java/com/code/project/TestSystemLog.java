package com.code.project;

import com.code.project.biz.dao.UserLogDAO;
import com.code.project.biz.dataobject.UserLogDO;
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
public class TestSystemLog {

    @Autowired
    UserLogDAO userLogDAO;


    @Test
    public void testInsert() {
        try {
            UserLogDO userLogDO = new UserLogDO();
            userLogDO.setUserName("username");
            userLogDO.setContent("content");
            userLogDO.setUserTime(new Date());
            userLogDAO.add(userLogDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testUpdate() {
        try {
            UserLogDO userLogDO = new UserLogDO();
            userLogDO.setUserName("username");
            userLogDO.setContent("content123");
            userLogDO.setUserTime(new Date());
            userLogDAO.update(userLogDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuery() {
        try {
            UserLogDO userLogDO = new UserLogDO();
            userLogDO.setUserName("username");
            userLogDO.setContent("content123");
            List<UserLogDO> list = userLogDAO.select(userLogDO);
            for(UserLogDO i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
