package com.ems.ems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_department")
@NoArgsConstructor
@AllArgsConstructor
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "short_code", length = 10)
    private String shortCode;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(targetEntity = Employee.class, mappedBy = "department")
    private List<Employee> employeeList;

}
