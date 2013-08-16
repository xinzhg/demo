package com.code.project.biz.dao.impl;


import com.code.project.biz.dao.UserInfoDAO;
import com.code.project.biz.dataobject.UserInfoDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxin
 * Date: 13-6-18
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoDAOImpl extends BaseDAOImpl implements UserInfoDAO {
    public Integer add(UserInfoDO userInfoDO) throws Exception {
        return (Integer)getSqlMapClientTemplate().insert("UserInfoDAO.insert",userInfoDO);
    }

    public boolean update(UserInfoDO userInfoDO) throws Exception {
        return getSqlMapClientTemplate().update("UserInfoDAO.update",userInfoDO) > 0;
    }

    public List<UserInfoDO> select(UserInfoDO userInfoDO) throws Exception {
        return (List<UserInfoDO>)getSqlMapClientTemplate().queryForList("UserInfoDAO.select",userInfoDO);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return getSqlMapClientTemplate().delete("UserInfoDAO.delete",id) > 0;
    }

}
