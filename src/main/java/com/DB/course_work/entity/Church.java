package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "church")
@Data
@NoArgsConstructor
public class Church {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String believe;
    @Column
    private String prayerTime;
    @Column
    private String endTime;
    @ManyToOne
    @JoinColumn(name = "id_building")
    private Building building;
}
