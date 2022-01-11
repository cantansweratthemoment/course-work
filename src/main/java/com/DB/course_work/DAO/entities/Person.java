package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private Integer id;

    private String name;

    private Location_Person location_person;

    private Person manager;

    public Integer getId_manager() {
        if (manager != null) return manager.getId();
        return null;
    }

    public void setId_manager(Integer id) {
       if (manager != null) {
           manager.setId(id);
       }else {
           setManage(id);
       }
    }

    public void setManage(Integer id) {
        manager = new Person(id, null, null, null);
    }
}
