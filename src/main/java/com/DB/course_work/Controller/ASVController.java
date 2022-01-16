package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.entities.Staff_Volunteers;
import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/normal") // normal person
public class ASVController extends BasicController{
    @Autowired
    private StaffService staffService;

    @RequestMapping("/showManager")
    JsonResult<Person> showManager(HttpSession session){
        String username = (String) session.getAttribute("username");
        Person manager = staffService.findManagerByLogin(username);
        return new JsonResult<>(OK, manager);
    }

    @RequestMapping("/showEvent")
    JsonResult<List<Event>> showEvent(HttpSession session){
        Integer uid = (Integer) session.getAttribute("uid");
        List <Event> result = staffService.findOwnEventsByUID(uid);
        return new JsonResult<>(OK, result);
    }
}
