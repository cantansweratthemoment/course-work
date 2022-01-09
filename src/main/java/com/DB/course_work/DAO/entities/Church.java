package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Church {
    private Integer id;

    private String name;

    private String believe;

    private Time prayer_time;

    private Time end_time;

    private Building building;

    public Integer getId_building(){
        return building.getId();
    }
}
