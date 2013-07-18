package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.SystemLogDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.SystemLogDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class SystemLogDAOImpl extends BaseDAOImpl implements SystemLogDAO {
    @Override
    public Integer add(SystemLogDO systemLogDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("SystemLogDAO.insert",systemLogDO);
    }

    @Override
    public boolean update(SystemLogDO systemLogDO) throws Exception {
        return getSqlMapClientTemplate().update("SystemLogDAO.update",systemLogDO) > 0;
    }

    @Override
    public List<SystemLogDO> select(SystemLogDO systemLogDO) throws Exception {
        return getSqlMapClientTemplate().queryForList("SystemLogDAO.select",systemLogDO);
    }
}
