package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Training_Place;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Training_PlaceMapper {
    @Select("select * from Training_Place")
    List<Training_Place> getAllTraining_Place();
}
