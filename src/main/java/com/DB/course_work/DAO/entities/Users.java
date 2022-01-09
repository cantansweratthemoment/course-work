package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private Integer id;

    // login is username.
    private String login;

    private Integer role;

    private String password;

    private Person person;

    private String salt;

    public Integer getId_person(){
        return person.getId();
    }
}
