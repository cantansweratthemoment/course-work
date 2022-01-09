package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.entities.Staff_Volunteers;
import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.mapper.AthleteMapper;
import com.DB.course_work.DAO.mapper.PersonMapper;
import com.DB.course_work.DAO.mapper.Staff_VolunteersMapper;
import com.DB.course_work.DAO.mapper.UsersMapper;
import com.DB.course_work.Service.Exceptions.InsertException;
import com.DB.course_work.Service.Exceptions.UsernameDuplicatedException;
import com.DB.course_work.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private AthleteMapper athleteMapper;

    @Autowired
    private Staff_VolunteersMapper staff_volunteersMapper;

    @Override
    public void BasicReg(Users users) {
        // Check if the username has existed.
        String username = users.getLogin();
        Users result = usersMapper.findUserByLogin(username);
        if (result != null) {
            throw new UsernameDuplicatedException("This username has existed!");
        }

        String oldPassword = users.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMD5Password(oldPassword, salt);

        users.setPassword(md5Password);
        users.setSalt(salt);
        users.setPerson(null);

        Integer rows = usersMapper.createUser(users);
        if (rows != 1) {
            throw new InsertException("Exception about insert instruction.");
        }
    }

    @Override
    public void regAsPerson(Users user, Person person) {
        personMapper.createPerson(person);
        usersMapper.updatePersonId(user.getLogin(), person.getId());
    }

    @Override
    public void regAsAthlete(Integer userId, Athlete athlete) {

    }


    @Override
    public void regAsSV(Integer userId, Staff_Volunteers SV) {

    }

    private String getMD5Password(String password, String salt) {
        // md5
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
