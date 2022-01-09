package com.DB.course_work.DAO.mapper;

//import com.example.demo.DAO.entities.Athlete;

import com.DB.course_work.DAO.entities.Athlete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AthleteMapper {

    @Select("select * from athlete where nationality = #{nationality}")
    List<Athlete> findByNationality(String nationality);

    @Select("select * from athlete where id = #{id}")
    Athlete findAthleteById(Integer id);

    @Insert("insert into athlete(height, weight, nationality, sport, record, id_person) " +
            "values (#{height}, #{weight}, #{nationality}, #{sport}, #{record}, #{id_person})")
    int createAthlete(double height, double weight, String nationality, String sport, String record, Integer id_person);

    @Select("select * from athlete where id_person = #{id_person}")
    Athlete findAthleteByIdPerson(Integer id_person);
}
