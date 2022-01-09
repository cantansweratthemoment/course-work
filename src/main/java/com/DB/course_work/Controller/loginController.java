package com.DB.course_work.Controller;

import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class loginController {

    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("/queryUserList")
    public List<Users> queryUserList(){
        List<Users> usersList = usersMapper.getAllUsers();
        return usersList;
    }

//    @PostMapping("/register/{username}/{password}")
//    public int createUser(@PathVariable Integer login, String password){
//
//    }

}
