package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Workplace_staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Workplace_staffMapper {
    @Select("select * from Workplace_staff")
    List<Workplace_staff> getAllWorkplace_staff();

    @Insert("insert into workplace_staff(id_loc, id_building, details) values (#{id_loc}, #{id_building}, #{details})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insertWorkplace_staff(Workplace_staff workplace_staff);
}
