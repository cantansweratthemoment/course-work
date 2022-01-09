package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.*;

import java.util.List;

public interface ManagerService {
    List<Athlete> findOwnAthletes(String login);

    List<Staff_Volunteers> findOwnStaffVolunteers(String login);

    List<Location> findAllLocInfo();

    List<Building> findBuildingsByLocationId(Integer locationId);

    List<Person> findAllPersonHasNoManager();

    // SA means Staff and Athlete
    void setManager(Integer managerId, Integer SAId);
    void setManagers(Integer managerId, Integer[] SAIdList);

    void setEvent(Integer staffId, Event event);

    void setLocForStaff(Integer staffId, Integer locId);
}
