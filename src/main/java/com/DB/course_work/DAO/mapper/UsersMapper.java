package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {

    @Select({"select * from users"})
    List<Users> getAllUsers();

    @Select("select * from users where id = #{id}")
    Users findUserById(int id);

    // If not exist, return null.
    @Select("select * from users where login = #{login}")
    Users findUserByLogin(String login);

    @Insert("insert into users(login, role, password, salt) values(#{login}, #{role}, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer createUser(Users users);

    @Update("update users set id_person = #{id_person} where login = #{login}")
    Integer updatePersonId(String login, Integer id_person);

    @Select("select id from users where login = #{login}")
    Integer findIdByLogin(String login);
}
