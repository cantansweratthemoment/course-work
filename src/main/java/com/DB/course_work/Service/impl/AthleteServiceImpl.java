package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Location;
import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.mapper.PersonMapper;
import com.DB.course_work.DAO.mapper.UsersMapper;
import com.DB.course_work.Service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person findManagerByLogin(String SALogin) {
        return null;
    }

    @Override
    public List<Event> findOwnEvents(Integer AthleteId) {
        return null;
    }

    @Override
    public List<Location> findAllLocations() {
        return null;
    }

    @Override
    public Building findBuildingsByLocId(Integer LocationId) {
        return null;
    }
}
