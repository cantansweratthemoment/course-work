package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Staff_Volunteers", indexes = {@Index(name = "ID_WS_Person_index_SV", columnList = "id_ws, id_person", unique = true)})
public class Staff_Volunteers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_ws", referencedColumnName = "id")
    private Workplace_staff workplace_staff;

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;
}
