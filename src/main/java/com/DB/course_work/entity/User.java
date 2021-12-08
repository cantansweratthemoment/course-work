package com.DB.course_work.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String login;
    @Column
    private Long role;
    @Column
    private String password;
    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
