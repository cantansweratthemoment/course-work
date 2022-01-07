package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Location_Person;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Location_PersonMapper {
    @Select("select * from Location_Person")
    List<Location_Person> getAllLocation_Person();
}
