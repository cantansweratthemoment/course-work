package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Staff_Volunteers;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController extends BasicController{

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/manageList/0")
    public JsonResult<List<Athlete>> findAthleteBeManaged(HttpSession session){
        String username = (String) session.getAttribute("username");
            List<Athlete> athleteList = managerService.findOwnAthletes(username);
            return new JsonResult<>(OK, athleteList);
    }

    @RequestMapping("/manageList/1")
    public JsonResult<List<Staff_Volunteers>> findSVBeManaged(HttpSession session){
        String username = (String) session.getAttribute("username");
        List<Staff_Volunteers> SVList = managerService.findOwnStaffVolunteers(username);
        return new JsonResult<>(OK, SVList);
    }

}
