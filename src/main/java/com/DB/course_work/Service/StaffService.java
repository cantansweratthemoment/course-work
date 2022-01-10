package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Location;
import com.DB.course_work.DAO.entities.Person;

import java.util.List;

public interface StaffService {
    Person findManagerByLogin(String SALogin);
    List<Event> findOwnEvents(Integer StaffId);
    List<Location> findAllLocations();
    List<Building> findBuildingsByLocId(Integer LocationId);
}
