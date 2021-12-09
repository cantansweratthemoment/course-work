package com.DB.course_work.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @OneToOne
    @JoinColumn(name = "id_lp")
    private LocationPerson locationPerson;
    @ManyToOne
    @JoinColumn(name = "ID_Manager")
    private Manager manager;
}