package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private Ov_area ov_area;
}
