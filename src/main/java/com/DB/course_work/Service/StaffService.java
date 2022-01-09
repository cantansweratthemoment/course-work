package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Location;

import java.util.List;

public interface StaffService {
    String findManagerByLogin(String SALogin);
    List<Event> findOwnEvents(Integer StaffId);
    List<Location> findAllLocations();
    Building findBuildingsByLocId(Integer LocationId);
}
