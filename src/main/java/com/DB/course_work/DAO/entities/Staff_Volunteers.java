package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff_Volunteers implements Serializable {
    private Integer id;

    private Workplace_staff workplace_staff;

    private Person person;

    public Integer getId_person(){
        if (person != null) return person.getId();
        return null;
    }

    public Integer getId_ws(){
        if (workplace_staff != null) return workplace_staff.getId();
        return null;
    }

    public void setId_person(Integer id){
        person = new Person(id,null,null,null);
    }
}
