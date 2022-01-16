package com.DB.course_work.Service.impl;

import com.DB.course_work.DAO.entities.*;
import com.DB.course_work.DAO.mapper.AthleteMapper;
import com.DB.course_work.DAO.mapper.PersonMapper;
import com.DB.course_work.DAO.mapper.Staff_VolunteersMapper;
import com.DB.course_work.DAO.mapper.UsersMapper;
import com.DB.course_work.Service.Exceptions.InsertException;
import com.DB.course_work.Service.Exceptions.PasswordNotMatchException;
import com.DB.course_work.Service.Exceptions.UserNotFoundException;
import com.DB.course_work.Service.Exceptions.UsernameDuplicatedException;
import com.DB.course_work.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private AthleteMapper athleteMapper;

    @Autowired
    private Staff_VolunteersMapper staff_volunteersMapper;

    @Override
    public Integer BasicReg(Users users) {
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

        return users.getId();
    }

    @Override
    public void regAsPerson(Users user, String personName) {
        Person person = new Person(null, personName, null, null);
        personMapper.createPerson(person);
        user.setPerson(person);
        Integer id = person.getId();
        usersMapper.updatePersonId(user.getLogin(), id);
    }

    @Override
    public void regAsAthlete(String login, Athlete athlete) {
        Users user = usersMapper.findUserByLogin(login);
        Person person = personMapper.findPersonById(user.getId_person());
        Integer personId = person.getId();
        athlete.setId_person(personId);
        athleteMapper.createAthlete(athlete);
    }


    @Override
    public void regAsSV(Integer userId) {
        Users user = usersMapper.findUserById(userId);
        Person person = personMapper.findPersonById(user.getId_person());
        Staff_Volunteers SV = new Staff_Volunteers(null, new Workplace_staff(), person);
        staff_volunteersMapper.createSV(SV);
    }

    @Override
    public Users login(String username, String password) {
        // Check username in DB.
        Users result = usersMapper.findUserByLogin(username);
        if (result == null){
            throw new UserNotFoundException("You have not registered.");
        }
        String oldMD5Password = result.getPassword();
        String salt = usersMapper.findSaltByLogin(username);
        String newMD5Password = getMD5Password(password, salt);

        if(!newMD5Password.equals(oldMD5Password)){
            throw new PasswordNotMatchException("Wrong Password");
        }

        // No need salt for frontend.
        result.setSalt(null);

        return result;
    }


    private String getMD5Password(String password, String salt) {
        // md5. 3 times encrypt.
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
