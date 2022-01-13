package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.*;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.Exceptions.NoPermissionException;
import com.DB.course_work.Service.ManagerService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.Period;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController extends BasicController {

    @Autowired
    private ManagerService managerService;

    /**
     * Login at the first and will
     * @param session Will read username from session.
     * @return A hashmap. <Person, Athlete>
     */
    @RequestMapping("/manageList/0")
    public JsonResult<List<Athlete>> findAthleteBeManaged(HttpSession session) {
        Person person;
        HashMap<Person, Athlete> results = new HashMap<>();
        String username = (String) session.getAttribute("username");

        List<Athlete> athleteList = managerService.findOwnAthletes(username);
//        for(Athlete a : athleteList){
//            if (a == null) continue;
//            person = managerService.mapAthleteToPerson(a);
//            results.put(person, a);
//        }
        return new JsonResult<>(OK, athleteList);
    }

    @RequestMapping("/manageList/1")
    public JsonResult<List<Staff_Volunteers>> findSVBeManaged(HttpSession session) {
//        Person person;
//        HashMap<Person, Staff_Volunteers> results = new HashMap<>();
        String username = (String) session.getAttribute("username");

        List<Staff_Volunteers> SVList = managerService.findOwnStaffVolunteers(username);
//        for (Staff_Volunteers sv : SVList){
//            if (sv == null) continue;
//            person = managerService.mapSVToPerson(sv);
//            results.put(person, sv);
//        }
        return new JsonResult<>(OK, SVList);
    }

    @RequestMapping("/noManagerInfo")
    public JsonResult<List<Person>> findPersonNoManager() {
        return new JsonResult<>(OK, managerService.findAllPersonHasNoManager());
    }

    /**
     * Will check if the user is manager.
     *
     * @param SAUsername The username of person who you want to manage.
     * @param session    Get manager's username from here.
     * @return JsonResult<Void> Only Status
     */
    @RequestMapping("/managePerson/{SAUsername}")
    public JsonResult<Void> managePerson(@PathVariable String SAUsername, HttpSession session) {
        Integer role = (Integer) session.getAttribute("role");
        if (role != 2) {
            throw new NoPermissionException("You have now permission to do this.");
        }
        managerService.setManagerByUsername((String) session.getAttribute("username"), SAUsername);
        return new JsonResult<>(OK);
    }

    /**
     * Example: http://localhost:8080/manager/event/52/testEvent/train/00:00:00/00:00:00/2
     * @param SVAId Person Id.
     * @param event Event obj.
     * @return Status code.
     */
    @RequestMapping("/event/{SVAId}/{name}/{type}/{begin_time}/{end_time}/{id_loc}")
    public JsonResult<Void> manageEvent(@PathVariable Integer SVAId, Event event) {
        managerService.setEvent(SVAId, event);
        return new JsonResult<>(OK);
    }

    /**
     * Example: http://localhost:8080/manager/setLBId/14/5/14/No%20details%20fxck
     * @param staffId id of staff_volunteer.
     * @param ws Workplace_staff object.
     * @return Status code.
     */
    @RequestMapping("/setLBId/{staffId}/{id_loc}/{id_building}/{details}")
    public JsonResult<Void> setLBId(@PathVariable Integer staffId, Workplace_staff ws){
        managerService.setWorkplaceForStaff(staffId, ws);
        return new JsonResult<>(OK);
    }


}
