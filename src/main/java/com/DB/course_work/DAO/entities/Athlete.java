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
@Table(name = "athlete", indexes = {@Index(name = "Height_index_Athlete", columnList = "height(cm)"),
        @Index(name = "Weight_index_Athlete", columnList = "weight(kg)"),
        @Index(name = "ID_LP_index_Athlete", columnList = "id_person")})
public class Athlete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "height(cm)", columnDefinition = "numeric")
    private double height;

    @Column(name = "weight(kg)", columnDefinition = "numeric")
    private double weight;

    @Column(name = "nationality", columnDefinition = "varchar", length = 32)
    private String nationality;

    @Column(name = "sport", columnDefinition = "varchar", length = 32)
    private String sport;

    @Column(name = "record", columnDefinition = "text")
    private String record;

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;
}
