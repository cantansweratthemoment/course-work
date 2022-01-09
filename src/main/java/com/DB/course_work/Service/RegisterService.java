package com.DB.course_work.Service;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.entities.Staff_Volunteers;
import com.DB.course_work.DAO.entities.Users;

public interface RegisterService {
    void BasicReg(Users users);
    void regAsAthlete(Integer userId, Athlete athlete);
    void regAsSV(Integer userId, Staff_Volunteers SV);
    void regAsPerson(Users user, Person person);
}
