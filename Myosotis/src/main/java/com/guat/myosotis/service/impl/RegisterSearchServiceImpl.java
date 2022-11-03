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
        try {
            return employDao.selectAllName();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }

    @Override
    public List<String> deptSearch() {
        DeptDao deptDao = new DeptDaoImpl();
        try {
            return deptDao.selectAllName();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }
}
