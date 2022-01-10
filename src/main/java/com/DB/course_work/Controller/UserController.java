package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Location_Person;
import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.utils.JsonResult;
import com.DB.course_work.Service.IUserService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("users")
public class UserController extends BasicController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/reg/{login}/{password}/{role}/{realName}")
    /**
     * Example:
     * http://localhost:8080/users/reg/user0010/123456/0/Siyuan
     * */ public JsonResult<HashMap<String, String>> register(Users user, @PathVariable String realName) {
        Integer userId = userService.BasicReg(user);
        userService.regAsPerson(user, realName);

        HashMap<String, String> results = new HashMap<>();
        results.put("username", user.getLogin());
        results.put("role", user.getRole().toString());

        if (user.getRole() == 1) registerAsSV(userId);
        return new JsonResult<>(OK, results);
    }

    @RequestMapping("/reg/athlete/{login}/{height}/{weight}/{nationality}/{sport}")
    /**
     * Example:
     * http://localhost:8080/users/reg/athlete/user0010/01/01/CN/Football
     * */ public JsonResult<Void> registerAsAthlete(Athlete athlete, @PathVariable String login) {
        userService.regAsAthlete(login, athlete);
        return new JsonResult<>(OK);
    }

    /**
     * Example:
     * http://localhost:8080/users/login/user0012/123456
     */
    @RequestMapping("/login/{username}/{password}")
    public JsonResult<HashMap<String,String>> login(@PathVariable String username,
                                                    @PathVariable String password,
                                                    HttpSession session) {
        Users data = userService.login(username, password);
        session.setAttribute("uid", data.getId());
        session.setAttribute("username", data.getLogin());

        System.out.println(getuidFromSession(session));
        System.out.println(getUserNameFromSession(session));

        HashMap<String, String> results = new HashMap<>();
        results.put("username", data.getLogin());
        results.put("role", data.getRole().toString());
        return new JsonResult<>(OK, results);
    }

    public void registerAsSV(Integer userId) {
        userService.regAsSV(userId);
    }


}
