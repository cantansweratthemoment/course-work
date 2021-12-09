package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "info_olympic_village")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Info_olympic_village implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_iov", nullable = false)
    private Integer id;

    @Column(name = "description")
    private String description;
}
