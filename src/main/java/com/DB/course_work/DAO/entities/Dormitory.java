package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Dormitory", indexes = {@Index(name = "Name_index_Dormitory", columnList = "name"),
        @Index(name = "ID_Building_index_Dormitory", columnList = "id_building")})
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "dor_area", columnDefinition = "text")
    private String dor_area;

    @ManyToOne
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    private Building building;
}
