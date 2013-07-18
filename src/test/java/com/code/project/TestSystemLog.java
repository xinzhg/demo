package com.code.project;

import com.code.project.biz.dao.SystemLogDAO;
import com.code.project.biz.dao.UserLogDAO;
import com.code.project.biz.dataobject.SystemLogDO;
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
    SystemLogDAO systemLogDAO;


    @Test
    public void testInsert() {
        try {
            SystemLogDO systemLogDO = new SystemLogDO();
            systemLogDO.setServerName("servername");
            systemLogDO.setContent("content");
            systemLogDO.setSystemTime(new Date());
            systemLogDAO.add(systemLogDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testUpdate() {
        try {
            SystemLogDO systemLogDO = new SystemLogDO();
            systemLogDO.setServerName("servername");
            systemLogDO.setContent("content123");
            systemLogDO.setSystemTime(new Date());
            systemLogDAO.update(systemLogDO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQuery() {
        try {
            SystemLogDO systemLogDO = new SystemLogDO();
            systemLogDO.setServerName("servername");
            List<SystemLogDO> list = systemLogDAO.select(systemLogDO);
            for(SystemLogDO i : list) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
