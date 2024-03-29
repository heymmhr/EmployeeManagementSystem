package com.ems.ems.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_employee")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "fullname", length = 70)
    private String fullName;

    @Column(name = "mobile_number", length = 10)
    private String mobileNumber;

    @Column(name = "email", length = 80)
    private String email;

    private Integer age;

    @OneToOne(targetEntity = Laptop.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "laptop_id", foreignKey = @ForeignKey (name = "FK_EMPLOYEE_LAPTOPID"))
    private Laptop laptop;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "FK_EMPLOYEE_DEPARTMENTID"))
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "employee_course_mapping", foreignKey = @ForeignKey(name = "FK_JT_EMPLOYEE_COURSE_MAPPING"))
    private List<Course> courseList;
}
