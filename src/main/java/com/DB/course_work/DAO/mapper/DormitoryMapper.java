package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormitoryMapper {
    @Select("select * from dormitory")
    List<Dormitory> getAllDormitory();
}
