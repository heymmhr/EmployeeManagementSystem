package com.ems.ems.service;

import com.ems.ems.dto.CourseDto;

import java.io.IOException;
import java.util.List;

public interface CourseService {

    CourseDto saveCourse (CourseDto dto) throws IOException;

    List <CourseDto> findAllCourseList();

    CourseDto findCourseById(Integer id) throws IOException;

    void deleteCourseById(Integer id);
}
