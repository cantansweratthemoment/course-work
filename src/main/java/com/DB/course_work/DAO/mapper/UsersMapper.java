package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {

    @Select("select * from users")
    List<Users> getAllUsers();

    @Select("select * from users where id = #{id}")
    Users findUserById(int id);

    @Insert("insert into users(id, login), role, password, id_person) values(#{id}, #{login}), #{role}, #{password}, #{id_person})")
    void create(Integer id, String login, Integer role, String password, Integer person_id);
}
