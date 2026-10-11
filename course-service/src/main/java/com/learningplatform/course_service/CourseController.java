
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

    public CourseController() {
        courses.add(new Course(
            1L,
            "Python Programming Fundamentals",
            "LearnHub Learning Team",
            "Learn Python syntax, variables, functions, data structures, and problem-solving through beginner-friendly projects."
        ));

        courses.add(new Course(
            2L,
            "Web Development Essentials",
            "LearnHub Web Team",
            "Learn HTML, CSS, and JavaScript to build responsive websites and interactive web applications."
        ));

        courses.add(new Course(
            3L,
            "Cybersecurity Fundamentals",
            "LearnHub Security Team",
            "Explore networking, Linux basics, common security risks, and safe cybersecurity practice labs."
        ));

        courses.add(new Course(
            4L,
            "Introduction to Game Development",
            "LearnHub Game Dev Team",
            "Explore game design, player movement, game mechanics, and level design through small playable projects."
        ));
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        course.setId(
            courses.stream()
                .mapToLong(existing -> existing.getId())
                .max()
                .orElse(0L) + 1
        );

        courses.add(course);
        return course;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courses;
    }
}
