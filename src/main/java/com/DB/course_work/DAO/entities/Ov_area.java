package com.DB.course_work.DAO.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ov_area")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ov_area implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar", length = 32)
    private String name;

    @Column(name = "size(ha)", columnDefinition = "numeric")
    private Double size;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_village", referencedColumnName = "id_iov")
    private Info_olympic_village info_olympic_village;
}
