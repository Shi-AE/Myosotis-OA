package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.MyMeeting;
import com.guat.myosotis.dao.MyMeetingDao;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.dao.impl.MyMeetingDaoImpl;
import com.guat.myosotis.dao.impl.UserDaoImpl;
import com.guat.myosotis.service.MyMeetingService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class MyMeetingServiceImpl implements MyMeetingService {
    @Override
    public boolean insert(MyMeeting myMeeting, String account) {
        MyMeetingDao meetingDao = new MyMeetingDaoImpl();
        UserDao userDao = new UserDaoImpl();
        //查询员工编号
        String employId;
        if (account.contains("@")) {
            employId = userDao.selectEmployIdByEmil(account);
        } else {
            employId = userDao.selectEmployIdByPhoneNumber(account);
        }
        //合并会议信息
        myMeeting.setEmployId(employId);
        //存入会议信息
        int count = meetingDao.insert(myMeeting);
        SqlSessionUtil.commitSqlSession();
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<MyMeeting> getAllMeeting(String account) {
        MyMeetingDao myMeetingDao = new MyMeetingDaoImpl();
        UserDao userDao = new UserDaoImpl();
        String employId;
        if (account.contains("@")) {
            employId = userDao.selectEmployIdByEmil(account);
        } else {
            employId = userDao.selectEmployIdByPhoneNumber(account);
        }
        List<MyMeeting> myMeetings = myMeetingDao.selectAllByEmploy(employId);
        SqlSessionUtil.commitSqlSession();
        return myMeetings;
    }

    @Override
    public boolean deleteMeeting(String sId) {
        Long id = Long.valueOf(sId);
        MyMeetingDao myMeetingDao = new MyMeetingDaoImpl();
        int count = myMeetingDao.deleteById(id);
        SqlSessionUtil.commitSqlSession();
        if (count == 1) {
            return true;
        }
        return false;
    }


}
