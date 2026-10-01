package com.learningplatform.course_service;

public class Course {

    private Long id;
    private String title;
    private String instructor;
    private String description;

    public Course() {
    }

    public Course(Long id, String title, String instructor, String description) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}