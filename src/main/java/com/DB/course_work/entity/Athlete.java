package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "athlete")
@Data
@NoArgsConstructor
public class Athlete {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long height;
    @Column
    private Long weight;
    @Column
    private String nationality;
    @Column
    private String sport;
    @Column
    private String record;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
