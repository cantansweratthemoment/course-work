package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private Integer id;

    private String name;

    private Location_Person location_person;

    private Person manager;

    public Integer getId_manager(){
        return manager.getId();
    }

    public void setId_manager(Integer id){
        manager.setId(id);
    }

    public void setManage(Integer id){
        this.manager = new Person(id, null, null, null);
    }
}
