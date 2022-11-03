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
        try {
            int count = propertyDao.insert(property);
            return count == 1;
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }

    @Override
    public List<Property> getPropertyList() {
        PropertyDao propertyDao = new PropertyDaoImpl();
        try {
            return propertyDao.selectAll();
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }

    @Override
    public boolean updateProperty(String sId, String sNumber) {
        PropertyDao propertyDao = new PropertyDaoImpl();
        try {
            Long id = Long.valueOf(sId);
            int number = Integer.parseInt(sNumber);
            int count = propertyDao.updatePropertyById(new Property(id, null, number));
            return count == 1;
        } finally {
            SqlSessionUtil.commitSqlSession();
        }

    }

    @Override
    public boolean deleteProperty(String sId) {
        Long id = Long.valueOf(sId);
        PropertyDao propertyDao = new PropertyDaoImpl();
        try {
            int count = propertyDao.deletePropertyById(id);
            return count == 1;
        } finally {
            SqlSessionUtil.commitSqlSession();
        }
    }
}
