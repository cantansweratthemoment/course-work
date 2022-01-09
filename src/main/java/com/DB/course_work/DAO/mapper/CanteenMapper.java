package com.DB.course_work.DAO.mapper;

import com.DB.course_work.DAO.entities.Canteen;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CanteenMapper {
    @Select("select * from canteen")
    List<Canteen> getAllCanteen();
}
