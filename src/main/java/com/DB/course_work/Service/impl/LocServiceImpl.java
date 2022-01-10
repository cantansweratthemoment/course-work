package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.Location;
import com.DB.course_work.DAO.mapper.LocationMapper;
import com.DB.course_work.Service.LocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocServiceImpl implements LocService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> findAllLocInfo() {
        return locationMapper.getAllLocation();
    }
}
