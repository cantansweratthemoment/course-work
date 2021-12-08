package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "building")
@Data
@NoArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long size;
    @Column
    private String workingTime;
    @Column
    private String endTime;
    @OneToOne
    @JoinColumn(name = "id_loc")
    private Location location;
    @Column
    private String name;
}
