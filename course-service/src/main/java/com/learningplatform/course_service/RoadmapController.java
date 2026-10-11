package com.learningplatform.course_service;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/roadmaps")
@CrossOrigin
public class RoadmapController {
    private final List<Map<String, Object>> roadmaps = List.of(
        Map.of(
            "id", "python",
            "title", "Python Development",
            "description", "Learn programming fundamentals and build useful applications.",
            "duration", "4 weeks",
            "milestones", List.of(
                Map.of("title", "Python Basics",
                       "project", "Build a number guessing game"),
                Map.of("title", "Functions and Data Structures",
                       "project", "Create a personal expense tracker"),
                Map.of("title", "Files and APIs",
                       "project", "Build a weather information app")
            )
        ),

        Map.of(
            "id", "web-development",
            "title", "Web Development",
            "description", "Learn to create interactive websites.",
            "duration", "4 weeks",
            "milestones", List.of(
                Map.of("title", "HTML and CSS",
                       "project", "Create a personal portfolio page"),
                Map.of("title", "JavaScript Fundamentals",
                       "project", "Build a to-do list"),
                Map.of("title", "APIs and Integration",
                       "project", "Create a course finder website")
            )
        ),

        Map.of(
            "id", "cybersecurity",
            "title", "Cybersecurity",
            "description", "Explore networking, security fundamentals, and safe practice labs.",
            "duration", "4 weeks",
            "milestones", List.of(
                Map.of("title", "Computer and Network Basics",
                       "project", "Draw and explain a home network"),
                Map.of("title", "Linux and Security Fundamentals",
                       "project", "Create a Linux security checklist"),
                Map.of("title", "Web Security Basics",
                       "project", "Document findings from a legal practice lab")
            )
        ),

        Map.of(
            "id", "game-development",
            "title", "Game Development",
            "description", "Learn game mechanics and build a small playable game.",
            "duration", "4 weeks",
            "milestones", List.of(
                Map.of("title", "Game Design Fundamentals",
                       "project", "Design a simple game concept"),
                Map.of("title", "Movement and Game Mechanics",
                       "project", "Build a playable movement prototype"),
                Map.of("title", "Levels and Game Polish",
                       "project", "Create a small multi-level game")
            )
        )
    );

    @GetMapping
    public List<Map<String, Object>> getRoadmaps() {
        return roadmaps;
    }

    @GetMapping("/{goalId}")
    public ResponseEntity<Map<String, Object>> getRoadmap(
            @PathVariable String goalId) {

        return roadmaps.stream()
                .filter(roadmap -> roadmap.get("id").equals(goalId))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
