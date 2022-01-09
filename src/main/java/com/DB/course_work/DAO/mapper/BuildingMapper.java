package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BuildingMapper{
    @Select("select * from building")
    List<Building> getAllBuildings();

    @Select("select * from building where id_loc = #{locId}")
    List<Building> getBuildingsByLocId(Integer locId);
}
