package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Dormitory;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DormitoryMapper {
    @Select("select * from dormitory")
    List<Dormitory> getAllDormitory();
}
