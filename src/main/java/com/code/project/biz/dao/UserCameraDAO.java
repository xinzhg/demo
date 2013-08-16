package com.code.project.biz.dao;

import com.code.project.biz.dataobject.CameraDO;
import com.code.project.biz.dataobject.UserCameraDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxin
 * Date: 13-6-18
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface UserCameraDAO {

    Integer add(UserCameraDO userCameraDO) throws Exception;

    boolean update(UserCameraDO userCameraDO) throws Exception;

    List<UserCameraDO> select(UserCameraDO userCameraDO) throws Exception;

    boolean delete(int id) throws Exception;
}
