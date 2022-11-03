package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Announce;
import com.guat.myosotis.dao.AnnounceDao;
import com.guat.myosotis.dao.impl.AnnounceDaoImpl;
import com.guat.myosotis.service.AnnounceService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.io.File;
import java.util.List;

public class AnnounceServiceImpl implements AnnounceService {
    @Override
    public boolean insertAnnounce(Announce announce) {
        AnnounceDao announceDao = new AnnounceDaoImpl();
        try {
            int insert = announceDao.insert(announce);
            System.out.println(insert);
            return insert == 1;
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }

    @Override
    public List<Announce> getAllAnnounce() {
        AnnounceDao announceDao = new AnnounceDaoImpl();
        try {
            return announceDao.selectAllAnnounce();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }

    }

    @Override
    public boolean deleteAnnounce(String sId,String path) {
        Long id = Long.parseLong(sId);
        AnnounceDao announceDao = new AnnounceDaoImpl();
        try {
            //查地址
            String name = announceDao.selectUrlById(id);
            //删除服务器图片
            boolean delete;
            File file = new File(path + "/img/announce/" + name);
            if (!file.exists()) {
                delete = true;
            } else {
                delete = file.delete();
            }
            //数据库删信息
            if (delete) {
                int count = announceDao.deleteById(id);
                if (count != 1) {
                    delete = false;
                }
            }
            return delete;
        } finally {
            SqlSessionUtil.commitSqlSession();
        }

    }
}
