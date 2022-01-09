package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory {
    private Integer id;

    private String name;

    private String dor_area;

    private Building building;

    public Integer getId_building(){
        return building.getId();
    }
}
