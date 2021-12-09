package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person", indexes = {@Index(name = "Name_index_Person", columnList = "name"),
        @Index(name = "ID_LP_index_Person", columnList = "id_lp")})
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @OneToOne
    @JoinColumn(name = "id_lp", referencedColumnName = "id")
    private Location_Person location_person;

    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id")
    private Users users;
}
