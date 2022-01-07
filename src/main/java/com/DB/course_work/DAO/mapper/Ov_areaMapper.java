package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Ov_area;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Ov_areaMapper extends JpaRepository<Ov_area, Integer> {
    @Select("select * from Ov_area")
    List<Ov_area> getAllOv_area();
}
