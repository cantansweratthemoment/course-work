package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Training_Place implements Serializable {
    private Integer id;

    private String name;

    private String sport;

    private Building building;

    public Integer getId_building(){
        return building.getId();
    }
}
