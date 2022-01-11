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
    void setManagerById(Integer managerId, Integer SAId);

    void setManagerByUsername(String managerUsername, String SAUsername);

    void setManagers(Integer managerId, Integer[] SAIdList);

    void setEvent(Integer staffId, Event event);

    void setWorkplaceForStaff(Integer staffId, Workplace_staff ws);

//    public void setEventForPerson(Integer SVAId, Event event);
}
