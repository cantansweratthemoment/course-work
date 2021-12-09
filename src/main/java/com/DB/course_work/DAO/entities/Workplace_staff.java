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
@Table(name = "workplace_staff", indexes = {@Index(name = "ID_Loc_index_WS", columnList = "id_loc"),
        @Index(name = "ID_Building_index_WS", columnList = "id_building")})
public class Workplace_staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "details", columnDefinition = "text")
    private String details;

    @ManyToOne
    @JoinColumn(name = "id_loc", referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    private Building building;
}
