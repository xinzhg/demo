package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.SystemLogDAO;
import com.code.project.biz.dao.UserLogDAO;
import com.code.project.biz.dataobject.SystemLogDO;
import com.code.project.biz.dataobject.UserLogDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class UserLogDAOImpl extends BaseDAOImpl implements UserLogDAO {
    @Override
    public Integer add(UserLogDO userLogDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("UserLogDAO.insert",userLogDO);
    }

    @Override
    public boolean update(UserLogDO userLogDO) throws Exception {
        return getSqlMapClientTemplate().update("UserLogDAO.update",userLogDO) > 0;
    }

    @Override
    public List<UserLogDO> select(UserLogDO userLogDO) throws Exception {
        return getSqlMapClientTemplate().queryForList("UserLogDAO.select",userLogDO);
    }
}
