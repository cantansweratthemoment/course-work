package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Athlete implements Serializable {

    private Integer id;

    private double height;

    private double weight;

    private String nationality;

    private String sport;

    private String record;

    private Person person;

    public Integer getId_person() {
        if (person != null) return person.getId();
        return null;
    }

    public void setId_person(Integer id) {
        this.person = new Person(id, null, null, null);
    }
}
