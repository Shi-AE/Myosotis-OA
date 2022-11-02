package com.guat.myosotis.dao;

import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AdminDaoImplTest {
    @Test
    public void selectByAccount() {
        String account = "root";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        Cipher cipher = sqlSession.selectOne("admin.selectByAccount", account);
        System.out.println(cipher);
    }
}
