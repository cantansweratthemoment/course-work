package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Users;

import java.util.List;

public interface IUserService {
    Integer BasicReg(Users users);
    void regAsAthlete(String login, Athlete athlete);
    void regAsSV(Integer userId);
    void regAsPerson(Users user, String personName);

    /**
     * @param username Also called login
     * @param password
     * @return Users obj
     */
    Users login(String username, String password);
}
