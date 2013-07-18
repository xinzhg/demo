package com.code.project.biz.dao;

import com.code.project.biz.dataobject.CameraDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface UserCameraDAO {

    Integer add(CameraDO cameraDO) throws Exception;

    boolean update(CameraDO cameraDO) throws Exception;

    List<CameraDO> select(CameraDO cameraDO) throws Exception;

}
