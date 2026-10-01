package com.learningplatform.course_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {

    private final List<Course> courses = new ArrayList<>();

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        course.setId((long) (courses.size() + 1));
        courses.add(course);
        return course;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courses;
    }
}