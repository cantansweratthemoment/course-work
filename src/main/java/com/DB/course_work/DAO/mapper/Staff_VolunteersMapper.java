package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Staff_Volunteers;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Staff_VolunteersMapper {
    @Select("select * from Staff_Volunteers")
    List<Staff_Volunteers> getAllStaff_Volunteers();
}
