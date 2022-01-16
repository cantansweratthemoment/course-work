package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PersonMapper{
    @Select("select * from Person")
    List<Person> getAllPerson();

    @Select("select * from person where id = #{id}")
    Person findPersonById(Integer id);

    @Insert("insert into person(name) values (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer createPerson(Person person);

    @Select("select * from person where id_manager = #{id_manager}")
    List<Person> findPersonByIdManager(Integer id_manager);

    @Select("select p.id, p.name, p.id_lp, p.id_manager from users u join person p on p.id = u.id_person where role != 2 and id_manager is null;")
    List<Person> findAllASNoManager();

    @Update("update person set id_manager = #{id_manager} where id = #{SAId}")
    Integer updateManagementRelationship(Integer id_manager, Integer SAId);
}
