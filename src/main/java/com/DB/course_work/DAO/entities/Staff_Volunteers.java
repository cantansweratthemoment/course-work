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
        return person.getId();
    }

    public Integer getId_ws(){
        return workplace_staff.getId();
    }

    public void setId_person(Integer id){
        this.person.setId(id);
    }
}
