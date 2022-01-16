package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Event;
import com.DB.course_work.DAO.entities.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface EventMapper {
    @Select("select * from event")
    List<Event> getAllEvents();

    @Select("select * from event where id_person = #{id_person}")
    List<Event> findEventsByPersonId(Integer id_person);

    @Insert("insert into event(name, type, begin_time, end_time, id_person, id_loc) " +
            "values(#{name}, #{type}, #{begin_time}, #{end_time}, #{id_person}, #{id_loc})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer createEvent(Event event);

}
