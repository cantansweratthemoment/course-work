package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Ov_area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ov_areaMapper {
    @Select("select * from Ov_area")
    List<Ov_area> getAllOv_area();
}
