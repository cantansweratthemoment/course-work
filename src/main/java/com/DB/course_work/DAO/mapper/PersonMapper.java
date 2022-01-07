package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonMapper{
    @Select("select * from Person")
    List<Person> getAllPerson();
}
