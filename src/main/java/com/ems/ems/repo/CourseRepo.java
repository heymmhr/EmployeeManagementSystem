package com.ems.ems.repo;

import com.ems.ems.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository <Course, Integer> {


}
