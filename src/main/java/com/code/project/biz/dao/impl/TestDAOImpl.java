package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.TestDAO;
import com.code.project.biz.dataobject.TestDO;

import java.util.List;

public class TestDAOImpl  extends BaseDAOImpl  implements TestDAO{
    public boolean add(TestDO testDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("TestDAO.insert" , testDO) > 0;
    }

    public boolean update(TestDO testDO) throws Exception {
        return getSqlMapClientTemplate().update("TestDAO.update",testDO) > 0;
    }

    public List<TestDO> select(TestDO testDO) throws Exception {
        return (List<TestDO>)getSqlMapClientTemplate().queryForList("TestDAO.select",testDO);
    }
}
