package com.DB.course_work.DAO.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", length = 16)
    private String login;

    @Column(name = "role")
    private Integer role;

    @Column(name = "password", length = 32)
    private String password;

    @OneToOne
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;
}
