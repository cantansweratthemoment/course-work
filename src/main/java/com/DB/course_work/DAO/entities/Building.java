package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "building", indexes = {@Index(name = "Name_index_Building", columnList = "name"),
        @Index(name = "ID_Loc_index_Building", columnList = "id_loc"),
        @Index(name = "Work_index_Building", columnList = "working_time"),
        @Index(name = "End_index_Building", columnList = "end_time")})
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "size(ppl)", columnDefinition = "numeric")
    private Integer size;

    @Column(name = "working_time", columnDefinition = "time")
    private Time working_time;

    @Column(name = "end_time", columnDefinition = "time")
    private Time end_time;

    @ManyToOne
    @JoinColumn(name = "id_loc", referencedColumnName = "id")
    private Location location;
}
