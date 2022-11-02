package com.guat.myosotis.bean;

import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {
    @Test
    public void Test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    }
}
