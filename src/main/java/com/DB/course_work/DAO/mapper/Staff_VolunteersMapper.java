package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Person;
import com.DB.course_work.DAO.entities.Staff_Volunteers;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Staff_VolunteersMapper {
    @Select("select * from staff_volunteers")
    List<Staff_Volunteers> getAllStaff_Volunteers();

    @Select("select * from staff_volunteers where id_person = #{id_person}")
    Staff_Volunteers findSVByIdPerson(Integer IdPerson);

    @Select("select * from person where id = (select id from staff_volunteers where id = #{SVId})")
    Person findPersonBySVId(Integer SVId);

    @Insert("insert into staff_volunteers(id_ws, id_person) values (#{id_ws}, #{id_person})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void createSV(Staff_Volunteers SV);

    @Update("update staff_volunteers set id_ws = #{id_ws} where id = #{SVId}")
    Integer setWorkplaceToSV(Integer id_ws, Integer SVId);
}
