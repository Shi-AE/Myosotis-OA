package com.guat.myosotis.dao;

import com.guat.myosotis.dao.impl.UserDaoImpl;
import com.guat.myosotis.util.SqlSessionUtil;
import org.junit.Test;

public class UserDaoImplTest {
    @Test
    public void test() {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.updateTokenByPhoneNumber("13738377227" ,"testToken2");
        SqlSessionUtil.commitSqlSession();
    }
}
