package com.DB.course_work.DAO.repository;

//import com.example.demo.DAO.entities.Athlete;
import com.DB.course_work.DAO.entities.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
    List<Athlete> findByNationality(String nationality);
}
