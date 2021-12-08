package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "canteen")
@Data
@NoArgsConstructor
public class Canteen {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String foodKind;
    @Column
    private boolean isHalal;
    @Column
    private Long evaluation;
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;
}
