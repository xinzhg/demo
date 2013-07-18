package com.code.project.biz.dao;

import com.code.project.biz.dataobject.UserLogDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface UserLogDAO {

    Integer add(UserLogDO userLogDO) throws Exception;

    boolean update(UserLogDO userLogDO) throws Exception;

    List<UserLogDO> select(UserLogDO userLogDO) throws Exception;

}
