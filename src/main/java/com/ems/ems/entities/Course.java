package com.ems.ems.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbl_course")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "is_nepali_board")
    private Boolean isNepaliBoard;

    @Column(name = "file_path")
    private String filePath;
}
