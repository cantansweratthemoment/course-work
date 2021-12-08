package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;
}
