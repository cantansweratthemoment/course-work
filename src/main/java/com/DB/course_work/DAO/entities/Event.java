package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    public Integer getId_person() {
        if (person != null) return person.getId();
        return null;
    }

    public Integer getId_loc() {
        if (location != null) return location.getId();
        return null;
    }

    public void setId_person(Integer id){
        person = new Person(id,null,null,null);
    }

    public void setId_loc(Integer id){
        location = new Location(id, null, null, null);
    }
}
