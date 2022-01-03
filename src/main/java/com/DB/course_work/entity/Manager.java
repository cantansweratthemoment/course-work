package com.DB.course_work.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "manager")
@Data
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
//    @OneToMany
}
