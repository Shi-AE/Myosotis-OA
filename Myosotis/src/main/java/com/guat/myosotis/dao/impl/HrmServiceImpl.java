package com.guat.myosotis.dao.impl;

import com.guat.myosotis.bean.Admin;
import com.guat.myosotis.bean.Cipher;
import com.guat.myosotis.bean.User;
import com.guat.myosotis.dao.AdminDao;
import com.guat.myosotis.dao.UserDao;
import com.guat.myosotis.service.HrmService;
import com.guat.myosotis.util.MD5;
import com.guat.myosotis.util.SqlSessionUtil;

public class HrmServiceImpl implements HrmService {
    @Override
    public boolean updateUserPassword(String account, String password) {
        Cipher cipher = MD5.MD5AddSalt(password);
        UserDao userDao = new UserDaoImpl();
        User user;
        int count = 0;
        if (account.contains("@")) {
            user = new User(
                    null,
                    cipher.getCipherText(),
                    cipher.getSalt(),
                    null,
                    account,
                    "",
                    null
            );
            count = userDao.updatePasswordByEmil(user);
        } else {
            user = new User(
                    null,
                    cipher.getCipherText(),
                    cipher.getSalt(),
                    account,
                    null,
                    "",
                    null
            );
            count = userDao.updatePasswordByPhoneNumber(user);
        }
        SqlSessionUtil.commitSqlSession();
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdminPassword(String handle, String password) {
        Cipher cipher = MD5.MD5AddSalt(password);
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = new Admin(
                cipher.getCipherText(),
                cipher.getSalt(),
                null,
                handle,
                null
        );
        int count = 0;
        try {
            count = adminDao.updatePasswordByAccount(admin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean AddAdmin(Admin admin,String password) {
        Cipher cipher = MD5.MD5AddSalt(password);
        admin.setCipherText(cipher.getCipherText());
        admin.setSalt(cipher.getSalt());
        AdminDao adminDao = new AdminDaoImpl();
        int count = 0;
        try {
            count = adminDao.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
}
