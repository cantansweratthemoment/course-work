package com.DB.course_work.DAO.repository;

import com.DB.course_work.DAO.entities.Church;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChurchRepository extends JpaRepository<Church, Integer> {
}
