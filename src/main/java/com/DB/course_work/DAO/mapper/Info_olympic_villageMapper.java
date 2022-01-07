package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Info_olympic_village;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Info_olympic_villageMapper {
    @Select("select * from Info_olympic_village")
    List<Info_olympic_village> getAllInfo_olympic_village();
}
