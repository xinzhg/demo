package com.code.project.biz.dao;

import com.code.project.biz.dataobject.TestDO;

import java.util.List;

public interface TestDAO {

    boolean add(TestDO testDO) throws Exception;

    boolean update(TestDO testDO) throws Exception;

    List<TestDO> select(TestDO testDO) throws Exception;

}
