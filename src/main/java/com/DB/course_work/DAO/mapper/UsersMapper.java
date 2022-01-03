package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {

    @Select("select * from users")
    List<Users> getUsers();
}
