package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "info_olympic_village")
@Data
@NoArgsConstructor
public class InfoOlympicVillage {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String description;
}
