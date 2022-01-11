package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.*;
import com.DB.course_work.DAO.mapper.*;
import com.DB.course_work.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public Person findManagerByLogin(String SALogin) {
        Users user = usersMapper.findUserByLogin(SALogin);
        Person person = personMapper.findPersonById(user.getId_person());
        return personMapper.findPersonById(person.getId_manager());
    }

    @Override
    public List<Event> findOwnEvents(Integer personId) {
        return eventMapper.findEventsByPersonId(personId);
    }

    public List<Event> findOwnEventsByUID(Integer uid){
        Users user = usersMapper.findUserById(uid);
        return findOwnEvents(user.getId_person());
    }

    @Override
    public List<Location> findAllLocations() {
        return locationMapper.getAllLocation();
    }

    @Override
    public List<Building> findBuildingsByLocId(Integer locationId) {
        return buildingMapper.getBuildingsByLocId(locationId);
    }
}
