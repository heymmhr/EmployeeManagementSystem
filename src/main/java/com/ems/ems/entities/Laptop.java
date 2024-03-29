package com.ems.ems.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_laptop")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String companyName;

    private String modelNo;

    @Column(name = "specification", columnDefinition = "TEXT")
    private String specification;
}
