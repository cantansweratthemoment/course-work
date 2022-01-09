package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ov_area implements Serializable {

    private Integer id;

    private String name;

    private Double size;

    private String description;

    private Info_olympic_village info_olympic_village;
}
