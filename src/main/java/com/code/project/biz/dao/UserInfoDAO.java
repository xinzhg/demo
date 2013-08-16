package com.code.project.biz.dao;

import com.code.project.biz.dataobject.UserInfoDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxin
 * Date: 13-6-18
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoDAO {

    Integer add(UserInfoDO userInfoDO) throws Exception;

    boolean update(UserInfoDO userInfoDO) throws Exception;

    List<UserInfoDO> select(UserInfoDO userInfoDO) throws Exception;

    boolean delete(int id) throws Exception;

}
