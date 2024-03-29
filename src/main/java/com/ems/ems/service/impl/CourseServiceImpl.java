package com.ems.ems.service.impl;


import com.ems.ems.dto.CourseDto;
import com.ems.ems.entities.Course;
import com.ems.ems.repo.CourseRepo;
import com.ems.ems.service.CourseService;
import com.ems.ems.utils.FileStorageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private FileStorageUtils fileStorageUtils;
    @Override
    public CourseDto saveCourse(CourseDto dto) throws IOException {

        MultipartFile multipartFile = dto.getCourseFile(); // need to save this file

        String filepath = fileStorageUtils.storeFile(multipartFile);

        Course entity = new Course().builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .isNepaliBoard(dto.getIsNepaliBoard())
                .price(dto.getPrice())
                .filePath(filepath)
                .build();

        entity = courseRepo.save(entity);


        return CourseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .isNepaliBoard(entity.getIsNepaliBoard())
                .filePath(entity.getFilePath())
                .build();
    }

    @Override
    public List<CourseDto> findAllCourseList() {

        List<Course> course = courseRepo.findAll();


        return course.stream().map(c ->
                CourseDto.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .description(c.getDescription())
                        .price(c.getPrice())
                        .isNepaliBoard(c.getIsNepaliBoard())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseRepo.deleteById(id);
    }

    @Override
    public CourseDto findCourseById(Integer id) throws IOException {

        Course c;
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if (optionalCourse.isPresent()){
            c = optionalCourse.get();

            /* I have file path here. I will read an image from storage and convert it to base64 and then display it*/


            return CourseDto.builder()
                    .id(c.getId())
                    .name(c.getName())
                    .description(c.getDescription())
                    .price(c.getPrice())
                    .isNepaliBoard(c.getIsNepaliBoard())
                    .filePath(fileStorageUtils.getBase64FileFromFilePath(c.getFilePath()))
                    .build();
        }
        return null;
    }
}
