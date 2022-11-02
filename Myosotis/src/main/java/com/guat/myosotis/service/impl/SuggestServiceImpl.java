package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Suggest;
import com.guat.myosotis.dao.EmployDao;
import com.guat.myosotis.dao.SuggestDao;
import com.guat.myosotis.dao.impl.EmployDaoImpl;
import com.guat.myosotis.dao.impl.SuggestDaoImpl;
import com.guat.myosotis.service.SuggestService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class SuggestServiceImpl implements SuggestService {
    @Override
    public boolean insert(String target, String content, String sender) {
        //获取员工编号
        EmployDaoImpl employDao = new EmployDaoImpl();
        target = employDao.selectEmployIdByName(target);
        //添加
        SuggestDao suggestDao = new SuggestDaoImpl();
        int insert = 0;
        try {
            insert = suggestDao.insert(new Suggest(null, target, content ,sender));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
        if (insert == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Suggest> getAllSuggest(String target) {
        SuggestDao suggestDao = new SuggestDaoImpl();
        EmployDao employDao = new EmployDaoImpl();
        List<Suggest> suggests = suggestDao.selectAllByTarget(target);
        suggests.forEach((e) -> {
            String sender = e.getSender();
            sender = employDao.selectNameByEmployId(sender);
            e.setSender(sender);
        });
        SqlSessionUtil.commitSqlSession();
        return suggests;
    }

    @Override
    public boolean deleteSuggest(String sid) {
        Long id = Long.valueOf(sid);
        //删除
        SuggestDao suggestDao = new SuggestDaoImpl();
        int count = suggestDao.deleteById(id);
        SqlSessionUtil.commitSqlSession();
        if (count == 1) {
            return true;
        }
        return false;
    }
}
