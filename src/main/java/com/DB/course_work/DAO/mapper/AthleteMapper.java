package com.DB.course_work.DAO.mapper;

//import com.example.demo.DAO.entities.Athlete;

import com.DB.course_work.DAO.entities.Athlete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AthleteMapper {

    @Select("select * from athlete where nationality = #{nationality}")
    List<Athlete> findByNationality(String nationality);

    @Select("select * from athlete where id = #{id}")
    Athlete findAthleteById(Integer id);
}
