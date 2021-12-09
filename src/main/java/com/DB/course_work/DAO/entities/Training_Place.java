package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Training_Place", indexes = {@Index(name = "Name_index_Training_Place", columnList = "name"),
        @Index(name = "Sport_index_Training_Place", columnList = "sport"),
        @Index(name = "ID_Building_Training_Place", columnList = "id_building")})
public class Training_Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "sport", columnDefinition = "text")
    private String sport;

    @ManyToOne
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    private Building building;
}
