package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workplace_staff implements Serializable {
    private Integer id;

    private String details;

    private Location location;

    private Building building;

    public Integer getId_loc(){
        if (location != null){
            return location.getId();
        }else return null;
    }

    public Integer getId_building(){
        if (building != null){
            return building.getId();
        }else return null;
    }

}
