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
@Table(name = "event", indexes = {@Index(name = "event_begin_time_index", columnList = "begin_time"),
        @Index(name = "event_end_time_index", columnList = "end_time"),
        @Index(name = "event_id_loc_index", columnList = "id_loc"),
        @Index(name = "event_id_person_index", columnList = "id_person"),
        @Index(name = "event_name_index", columnList = "name"),
        @Index(name = "event_type_index", columnList = "type")})
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "type", columnDefinition = "varchar", length = 32)
    private String type;

    @Column(name = "begin_time", columnDefinition = "time")
    private Time begin_time;

    @Column(name = "end_time", columnDefinition = "time")
    private Time end_time;

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_loc", referencedColumnName = "id")
    private Location location;


}
