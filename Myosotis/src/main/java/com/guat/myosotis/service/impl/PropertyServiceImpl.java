package com.guat.myosotis.service.impl;

import com.guat.myosotis.bean.Property;
import com.guat.myosotis.dao.PropertyDao;
import com.guat.myosotis.dao.impl.PropertyDaoImpl;
import com.guat.myosotis.service.PropertyService;
import com.guat.myosotis.util.SqlSessionUtil;

import java.util.List;

public class PropertyServiceImpl implements PropertyService {
    @Override
    public boolean addProperty(Property property) {
        PropertyDao propertyDao = new PropertyDaoImpl();
        int count = 0;
        try {
            count = propertyDao.insert(property);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
        return count == 1;
    }

    @Override
    public List<Property> getPropertyList() {
        PropertyDao propertyDao = new PropertyDaoImpl();
        List<Property> properties = propertyDao.selectAll();
        SqlSessionUtil.commitSqlSession();
        return properties;
    }

    @Override
    public boolean updateProperty(String sId, String sNumber) {
        PropertyDao propertyDao = new PropertyDaoImpl();
        int count = 0;
        try {
            Long id = Long.valueOf(sId);
            int number = Integer.parseInt(sNumber);
            count = propertyDao.updatePropertyById(new Property(id, null, number));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
        return count == 1;
    }

    @Override
    public boolean deleteProperty(String sId) {
        Long id = Long.valueOf(sId);
        PropertyDao propertyDao = new PropertyDaoImpl();
        int count = propertyDao.deletePropertyById(id);
        SqlSessionUtil.commitSqlSession();
        return count == 1;
    }
}
