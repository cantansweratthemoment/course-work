package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Canteen", indexes = {@Index(name = "Name_Index_Canteen", columnList = "name"),
        @Index(name = "Food_Kind_Index_Canteen", columnList = "food_kind"),
        @Index(name = "is_Halal_Index_Canteen", columnList = "is_halal"),
        @Index(name = "ID_Building_Index_Canteen", columnList = "id_building")})
public class Canteen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "food_kind", columnDefinition = "varchar", length = 32)
    private String believe;

    @Column(name = "is_halal")
    private boolean is_halal;

    @Column(name = "evaluation")
    private Integer evaluation;

    @ManyToOne
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    private Building building;
}
