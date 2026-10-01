package com.learningplatform.enrollment_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
@CrossOrigin
public class EnrollmentController {

    private final List<Enrollment> enrollments = new ArrayList<>();

    @PostMapping
    public Enrollment enroll(@RequestBody Enrollment enrollment) {
        enrollment.setId((long) (enrollments.size() + 1));
        enrollments.add(enrollment);
        return enrollment;
    }

    @GetMapping
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}

class Enrollment {

    private Long id;
    private Long studentId;
    private Long courseId;

    public Enrollment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}