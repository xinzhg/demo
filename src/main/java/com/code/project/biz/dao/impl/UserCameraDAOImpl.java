package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.CameraDAO;
import com.code.project.biz.dao.UserCameraDAO;
import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserCameraDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxin
 * Date: 13-6-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class UserCameraDAOImpl extends BaseDAOImpl implements UserCameraDAO {
    @Override
    public Integer add(UserCameraDO userCameraDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("UserCameraDAO.insert",userCameraDO);
    }

    @Override
    public boolean update(UserCameraDO userCameraDO) throws Exception {
        return getSqlMapClientTemplate().update("UserCameraDAO.update",userCameraDO) >  0;
    }

    @Override
    public List<UserCameraDO> select(UserCameraDO userCameraDO) throws Exception {
        return getSqlMapClientTemplate().queryForList("UserCameraDAO.select",userCameraDO);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return getSqlMapClientTemplate().delete("UserCameraDAO.delete",id) > 0;
    }
}
