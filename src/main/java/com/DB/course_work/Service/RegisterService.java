package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Users;

public interface RegisterService {
    Integer BasicReg(Users users);
    void regAsAthlete(String login, Athlete athlete);
    void regAsSV(Integer userId);
    void regAsPerson(Users user, String personName);
}
