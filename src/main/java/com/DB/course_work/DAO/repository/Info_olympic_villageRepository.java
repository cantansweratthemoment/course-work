package com.DB.course_work.DAO.repository;

import com.DB.course_work.DAO.entities.Info_olympic_village;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Info_olympic_villageRepository extends JpaRepository<Info_olympic_village, Integer> {
    Info_olympic_village getById(Integer id);
}
