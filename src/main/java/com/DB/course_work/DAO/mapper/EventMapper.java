package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Event;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventMapper {
    @Select("select * from event")
    List<Event> getAllEvents();
}
