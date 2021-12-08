package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "location_person")
@Data
@NoArgsConstructor
public class LocationPerson {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_loc")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;
    @Column
    private String details;
}
