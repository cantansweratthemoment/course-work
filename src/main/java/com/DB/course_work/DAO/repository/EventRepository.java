package com.DB.course_work.DAO.repository;

import com.DB.course_work.DAO.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
