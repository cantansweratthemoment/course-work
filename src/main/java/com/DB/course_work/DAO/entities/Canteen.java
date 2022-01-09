package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canteen {
    private Integer id;

    private String name;

    private String believe;

    private boolean is_halal;

    private Integer evaluation;

    private Building building;

    public Integer getId_building(){
        return building.getId();
    }
}
