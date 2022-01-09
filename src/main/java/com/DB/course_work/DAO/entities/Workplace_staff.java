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
}
