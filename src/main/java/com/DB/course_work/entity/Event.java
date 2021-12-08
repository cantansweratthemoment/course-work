package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "event")
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @Column
    private String beginTime;
    @Column
    private String endTime;
    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "id_loc")
    private Location location;
}
