package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.Ingres9Dialect;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
    private Integer id;

    private String name;

    private String type;

    private Time begin_time;

    private Time end_time;

    private Person person;

    private Location location;


    // There 2 getters are for FK.
    public Integer getId_person(){
        return person.getId();
    }

    public Integer getId_loc(){
        return location.getId();
    }
}
