package com.guat.myosotis.service.impl;

import com.guat.myosotis.dao.DeptDao;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.dao.impl.DeptDaoImpl;
import com.guat.myosotis.dao.impl.EmployDaoImpl;
import com.guat.myosotis.service.RegisterSearchService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class RegisterSearchServiceImpl implements RegisterSearchService {
    @Override
    public List<String> managerSearch() {
        EmployDao employDao = new EmployDaoImpl();
        List<String> names = employDao.selectAllName();
        SqlSessionUtil.commitSqlSession();
        return names;
    }

    @Override
    public List<String> deptSearch() {
        DeptDao deptDao = new DeptDaoImpl();
        List<String> names = deptDao.selectAllName();
        return names;
    }
}
