package com.DB.course_work.DAO.repository;

import com.DB.course_work.DAO.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
