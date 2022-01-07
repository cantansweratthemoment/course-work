package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Workplace_staff;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Workplace_staffMapper {
    @Select("select * from Workplace_staff")
    List<Workplace_staff> getAllWorkplace_staff();
}
