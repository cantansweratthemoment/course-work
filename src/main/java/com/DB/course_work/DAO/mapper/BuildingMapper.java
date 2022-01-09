package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Building;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingMapper{
    @Select("select * from building")
    List<Building> getAllBuildings();
}
