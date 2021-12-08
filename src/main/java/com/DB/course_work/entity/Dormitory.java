package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dormitory")
@Data
@NoArgsConstructor
public class Dormitory {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String dor_area;
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;
}
