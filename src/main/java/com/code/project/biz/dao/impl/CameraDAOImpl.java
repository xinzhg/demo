package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserInfoDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class CameraDAOImpl extends BaseDAOImpl implements CameraDAO {
    @Override
    public Integer add(CameraDO cameraDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("CameraDAO.insert" , cameraDO);
    }

    @Override
    public boolean update(CameraDO cameraDO) throws Exception {
        return getSqlMapClientTemplate().update("CameraDAO.update" , cameraDO) >0;
    }

    @Override
    public List<CameraDO> select(CameraDO cameraDO) throws Exception {
        return getSqlMapClientTemplate().queryForList("CameraDAO.select" , cameraDO);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return getSqlMapClientTemplate().delete("CameraDAO.delete" , id) > 0;
    }
}
