package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Info_olympic_village;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface Info_olympic_villageMapper {
    @Select("select * from Info_olympic_village")
    List<Info_olympic_village> getAllInfo_olympic_village();

    @Select("select * from Info_olympic_village where id = #{id}")
    Info_olympic_village findInfo_olympic_villageById(Integer id);
}
