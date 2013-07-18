package com.code.project.biz.dao;

import com.code.project.biz.dataobject.SystemLogDO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinnan.zx
 * Date: 13-6-18
 * Time: 下午2:27
 * To change this template use File | Settings | File Templates.
 */
public interface SystemLogDAO {

    Integer add(SystemLogDO systemLogDO) throws Exception;

    boolean update(SystemLogDO systemLogDO) throws Exception;

    List<SystemLogDO> select(SystemLogDO systemLogDO) throws Exception;

}
