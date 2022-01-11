package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Location;

import java.util.List;

public interface LocService {
    List<Location> findAllLocInfo();

    List<Building> findBuildingsByLocId(Integer LocId);
}
