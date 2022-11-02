package com.guat.myosotis.dao;

import com.guat.myosotis.dao.impl.EmployDaoImpl;
import org.junit.Test;

import java.util.List;

public class EmployTest {
    @Test
    public void test() {
        EmployDaoImpl employDao = new EmployDaoImpl();
        List<String> strings = employDao.selectAllName();
        System.out.println(strings);
    }
}
