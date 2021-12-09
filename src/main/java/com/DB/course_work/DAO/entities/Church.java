package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Church", indexes = {@Index(name = "Name_index_Church", columnList = "name"),
        @Index(name = "Believe_index_Church", columnList = "believe"),
        @Index(name = "ID_Building_index_Church", columnList = "id_building")})
public class Church {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "believe", columnDefinition = "varchar", length = 32)
    private String believe;

    @Column(name = "prayer_time", columnDefinition = "time")
    private Time prayer_time;

    @Column(name = "end_time", columnDefinition = "time")
    private Time end_time;

    @ManyToOne
    @JoinColumn(name = "id_building", referencedColumnName = "id")
    private Building building;
}
