package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building implements Serializable {
    private Integer id;

    private String name;

    private Integer size;

    private Time working_time;

    private Time end_time;

    private Location location;
}
