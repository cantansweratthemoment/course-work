package com.DB.course_work.DAO.Service;

import com.DB.course_work.DAO.repository.AthleteRepository;
import com.DB.course_work.DAO.repository.Info_olympic_villageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;

    @Autowired
    private Info_olympic_villageRepository info_olympic_villageRepository;
}
