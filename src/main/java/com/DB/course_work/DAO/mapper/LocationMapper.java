package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Building;
import com.DB.course_work.DAO.entities.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper{
    @Select("select * from Location")
    List<Location> getAllLocation();

    @Select("select * from building where id_loc = #{idLoc}")
    List<Building> findBuildingsByLocId(Integer idLoc);
}
