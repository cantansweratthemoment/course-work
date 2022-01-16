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
    @Autowired
    private Workplace_staffMapper workplace_staffMapper;

    @Override
    public List<Athlete> findOwnAthletes(String login) {
        Users managerUser = usersMapper.findUserByLogin(login);
        Integer managerPersonId = managerUser.getId_person();
        List<Person> ListOfAthletesAsPerson = personMapper.findPersonByIdManager(managerPersonId);
        List<Athlete> result = new ArrayList<>(ListOfAthletesAsPerson.size());
        for (Person person : ListOfAthletesAsPerson) {
            if (person == null) continue;
            Athlete athlete = athleteMapper.findAthleteByIdPerson(person.getId());
            if (athlete == null) continue;
            athlete.setPerson(person);
            result.add(athlete);
        }
        return result;
    }

    @Override
    public List<Staff_Volunteers> findOwnStaffVolunteers(String login) {
        Users managerUser = usersMapper.findUserByLogin(login);
        Integer managerPersonId = managerUser.getId_person();
        List<Person> ListOfSVAsPerson = personMapper.findPersonByIdManager(managerPersonId);
        List<Staff_Volunteers> result = new ArrayList<>(ListOfSVAsPerson.size());
        for (Person person : ListOfSVAsPerson) {
            if (person == null) continue;
            Staff_Volunteers SV = staff_volunteersMapper.findSVByIdPerson(person.getId());
            if (SV == null) continue;
            SV.setPerson(person);
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
    public List<Users> findAllPersonHasNoManager() {
        List<Person> personResult = personMapper.findAllASNoManager();
        List<Users> result = new ArrayList<>();
        for(Person person : personResult){
            if (person == null) continue;
            if (person.getId() == null) continue;
            Users user = usersMapper.findUserByIdPerson(person.getId());
            if (user == null) continue;
            user.setPerson(person);
            result.add(user);
        }
        return result;
    }

    @Override
    public void setManagerById(Integer managerId, Integer SAId) throws ServiceException {
        Integer result = personMapper.updateManagementRelationship(managerId, SAId);
        if (result != 1) throw new UpdateException("Exception about update manager and SV.");
    }

    public void setManagerByUsername(String username, String SAUsername) throws ServiceException {
        Users userManager = usersMapper.findUserByLogin(username);
        Integer idPersonManager = userManager.getId_person();
        Users SAUser = usersMapper.findUserByLogin(SAUsername);
        Integer SAPersonId = SAUser.getId_person();

        setManagerById(idPersonManager, SAPersonId);
    }


    @Override
    public void setManagers(Integer managerId, Integer[] SVIdList) {
        for (Integer svId : SVIdList) {
            setManagerById(managerId, svId);
        }
    }

    @Override
    public void setEvent(Integer staffId, Event event) throws ServiceException {
        Person staff = personMapper.findPersonById(staffId);
        event.setPerson(staff);
        Integer result = eventMapper.createEvent(event);
        if (result != 1) throw new InsertException("Exception about manage events.");
    }

    @Override
    public void setWorkplaceForStaff(Integer staffId, Workplace_staff ws) {
        Integer buildingId = ws.getId_building();
        Integer locId = ws.getId_loc();
        String details = ws.getDetails();

        Workplace_staff workplace_staff = new Workplace_staff();
        workplace_staff.setId_building(buildingId);
        workplace_staff.setId_loc(locId);
        workplace_staff.setDetails(details);
        Integer result = workplace_staffMapper.insertWorkplace_staff(workplace_staff);
        if (result != 1) {
            throw new InsertException("Problem about set location or building to staffs and volunteers as workplace.");
        } else System.out.println("Insert workplace_staff successfully!");

        Integer id_ws = workplace_staff.getId();
        Integer result2 = staff_volunteersMapper.setWorkplaceToSV(id_ws, staffId);
        if (result2 != 1) throw new UpdateException("Exception when set id_ws for SV.");
    }

    @Override
    public Person mapAthleteToPerson(Athlete athlete) {
        Integer id_person = athlete.getId_person();
        return personMapper.findPersonById(id_person);
    }

    @Override
    public Person mapSVToPerson(Staff_Volunteers sv) {
        Integer id_person = sv.getId_person();
        return personMapper.findPersonById(id_person);
    }
}
