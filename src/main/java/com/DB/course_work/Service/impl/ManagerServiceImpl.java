package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.*;
import com.DB.course_work.DAO.mapper.*;
import com.DB.course_work.Service.Exceptions.InsertException;
import com.DB.course_work.Service.Exceptions.ServiceException;
import com.DB.course_work.Service.Exceptions.UpdateException;
import com.DB.course_work.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AthleteMapper athleteMapper;
    @Autowired
    private Staff_VolunteersMapper staff_volunteersMapper;
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private EventMapper eventMapper;

    @Override
    public List<Athlete> findOwnAthletes(String login) {
        Integer managerId = usersMapper.findIdByLogin(login);
        List<Person> ListOfAthletesAsPerson = personMapper.findPersonByIdManager(managerId);
        List<Athlete> result = new ArrayList<>(ListOfAthletesAsPerson.size());
        for (Person person : ListOfAthletesAsPerson) {
            Athlete athlete = athleteMapper.findAthleteByIdPerson(person.getId());
            result.add(athlete);
        }
        return result;
    }

    @Override
    public List<Staff_Volunteers> findOwnStaffVolunteers(String login) {
        Integer managerId = usersMapper.findIdByLogin(login);
        List<Person> ListOfSVAsPerson = personMapper.findPersonByIdManager(managerId);
        List<Staff_Volunteers> result = new ArrayList<>(ListOfSVAsPerson.size());
        for (Person person : ListOfSVAsPerson) {
            Staff_Volunteers SV = staff_volunteersMapper.findSVByIdPerson(person.getId());
            result.add(SV);
        }
        return result;
    }

    @Override
    public List<Location> findAllLocInfo() {
        return locationMapper.getAllLocation();
    }

    @Override
    public List<Building> findBuildingsByLocationId(Integer locationId) {
        return buildingMapper.getBuildingsByLocId(locationId);
    }

    @Override
    public List<Person> findAllPersonHasNoManager() {
        return personMapper.findPersonByIdManager(null);
    }

    @Override
    public void setManager(Integer managerId, Integer SAId) throws ServiceException {
        Integer result = personMapper.updateManagementRelationship(managerId, SAId);
        if (result != 1) throw new UpdateException("Exception about update manager and SV.");
    }

    @Override
    public void setManagers(Integer managerId, Integer[] SVIdList) {
        for (Integer svId : SVIdList) {
            setManager(managerId, svId);
        }
    }

    @Override
    public void setEvent(Integer staffId, Event event) throws ServiceException{
        Person staff = personMapper.findPersonById(staffId);
        event.setPerson(staff);
        Integer result = eventMapper.createEvent(event);
        if (result != 1) throw new InsertException("Exception about manage events.");
    }

    @Override
    public void setLocForStaff(Integer staffId, Integer locId) {
        // TODO: 2022/1/9  
    }
}
