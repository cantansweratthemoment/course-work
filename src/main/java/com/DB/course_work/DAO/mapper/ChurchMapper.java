package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Church;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChurchMapper {
    @Select("select * from church")
    List<Church> getAllChurch();
}
