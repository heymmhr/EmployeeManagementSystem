package com.ems.ems.controller.course;


import com.ems.ems.dto.CourseDto;
import com.ems.ems.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String openCoursePage(Model model) {

        if (model.getAttribute("courseDto") == null)
            model.addAttribute("courseDto", new CourseDto());
        model.addAttribute("courseDtoList", courseService.findAllCourseList());

        //course list attach
        return "course/course";
    }

    @PostMapping
    public String saveCourse(@ModelAttribute CourseDto courseDto, RedirectAttributes redirectAttributes) throws IOException {

        courseDto = courseService.saveCourse(courseDto);
        String message;

        message = courseDto == null ? "Course cannot be saved" : "Course saved successfully";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/course";
    }

    // edit course

    @GetMapping("/find-courseby-edit-id/{id}")
    public String findCourseById(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws IOException {
        CourseDto courseDto = courseService.findCourseById(id);
        if (courseDto != null)
            redirectAttributes.addFlashAttribute("courseDto", courseDto);
        return "redirect:/course";
    }

    // view course

    @GetMapping("/find-courseby-id/{id}")
    public String findCourseById(@PathVariable Integer id, Model model) throws IOException {

        model.addAttribute("courseDto", courseService.findCourseById(id));
        return "course/viewpage";
    }

    // delete course
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Integer courseId, RedirectAttributes redirectAttributes) {
        String message = "Course deleted successfully";
        courseService.deleteCourseById(courseId);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/course";
    }
}
