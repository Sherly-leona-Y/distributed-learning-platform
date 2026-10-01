# LearnHub – Distributed Learning Platform

## 📌 Overview

LearnHub is a simple distributed learning platform built using a
microservices architecture.

The platform allows students to register, view available courses,
add courses, and enroll in courses.

The application is divided into three independent Spring Boot
microservices:

- User Service – handles student registration and user details
- Course Service – manages available courses
- Enrollment Service – handles course enrollments

A simple HTML, CSS, and JavaScript frontend communicates with these
services through REST APIs.

The project also demonstrates Git/GitHub, Docker, Docker Compose,
and Kubernetes for source code management, containerization, and
deployment.

## 🎯 Objectives

- Implement a basic distributed application using microservices
- Develop independent REST-based services using Spring Boot
- Connect a frontend with multiple backend services
- Containerize microservices using Docker
- Run multiple services using Docker Compose
- Deploy microservices using Kubernetes
- Manage the project using Git and GitHub

## 🏗️ Architecture

```text
                    ┌─────────────────────┐
                    │   LearnHub Frontend │
                    │   HTML/CSS/JS       │
                    └──────────┬──────────┘
                               │
             ┌─────────────────┼─────────────────┐
             │                 │                 │
             ▼                 ▼                 ▼
      ┌─────────────┐   ┌─────────────┐   ┌───────────────┐
      │ User        │   │ Course      │   │ Enrollment    │
      │ Service     │   │ Service     │   │ Service       │
      │ :8081       │   │ :8082       │   │ :8083         │
      └─────────────┘   └─────────────┘   └───────────────┘
             │                 │                 │
             ▼                 ▼                 ▼
           H2 DB          In-Memory List     In-Memory List
## ✨ Features

### 👤 User Management
- Student registration
- Stores user details using H2 database
- REST API for registering and retrieving users

### 📚 Course Management
- Add new courses
- View available courses
- Course details include title, instructor, and description

### 🎓 Enrollment
- Students can enroll in available courses
- Enrollment records contain student ID and course ID
- REST API for creating and viewing enrollments

### 🖥️ Frontend
- Simple and responsive web interface
- Student registration form
- Course listing page
- Course creation form
- Course enrollment button
- Built using HTML, CSS, and JavaScript

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Backend programming |
| Spring Boot | Microservices and REST APIs |
| Spring Data JPA | Database interaction |
| H2 Database | User data storage |
| HTML | Frontend structure |
| CSS | Frontend styling |
| JavaScript | Frontend functionality |
| Maven | Project build and dependency management |
| Git | Version control |
| GitHub | Source code management |
| Docker | Containerization |
| Docker Compose | Running multiple containers |
| Kubernetes | Container orchestration |

## 📁 Project Structure

```text
distributed-learning-platform/
│
├── user-service/
│   ├── src/
│   ├── pom.xml
│   ├── Dockerfile
│   └── ...
│
├── course-service/
│   ├── src/
│   ├── pom.xml
│   ├── Dockerfile
│   └── ...
│
├── enrollment-service/
│   ├── src/
│   ├── pom.xml
│   ├── Dockerfile
│   └── ...
│
├── frontend/
│   ├── index.html
│   ├── courses.html
│   ├── style.css
│   └── script.js
│
├── k8s/
│   └── k8s.yaml
│
├── docker-compose.yml
├── .gitignore
└── README.md
## 🚀 How to Run

### 1. Run the Spring Boot Services

Each service can be started independently using Maven.

#### User Service

    cd user-service
    .\mvnw.cmd spring-boot:run

Runs on: http://localhost:8081

#### Course Service

    cd course-service
    .\mvnw.cmd spring-boot:run

Runs on: http://localhost:8082

#### Enrollment Service

    cd enrollment-service
    .\mvnw.cmd spring-boot:run

Runs on: http://localhost:8083

---

## 🔗 API Endpoints

### User Service – Port 8081

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/users/register` | Register a new student |
| GET | `/users` | Get all registered users |

### Course Service – Port 8082

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/courses` | Add a new course |
| GET | `/courses` | Get all courses |

### Enrollment Service – Port 8083

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/enrollments` | Enroll a student in a course |
| GET | `/enrollments` | Get all enrollments |

---

## 🐳 Running with Docker

The project includes Dockerfiles for all three microservices.

### Build Docker Images

    docker build -t learnhub-user-service ./user-service
    docker build -t learnhub-course-service ./course-service
    docker build -t learnhub-enrollment-service ./enrollment-service

### Run with Docker Compose

From the project root:

    docker compose up -d

Check running containers:

    docker compose ps

Stop the containers:

    docker compose down

---

## ☸️ Kubernetes Deployment

The Kubernetes configuration is available in:

    k8s/k8s.yaml

Deploy the services:

    kubectl apply -f k8s/k8s.yaml

Check the pods:

    kubectl get pods

Check the services:

    kubectl get services

To remove the Kubernetes deployment:

    kubectl delete -f k8s/k8s.yaml

---

## 🌐 Frontend

The frontend is located in the `frontend` folder.

It can be opened using VS Code Live Server.

The frontend communicates with the three backend services through REST APIs.

### Main Pages

- `index.html` – Home page and student registration
- `courses.html` – Course listing, course creation, and enrollment

---

## 📌 Project Highlights

- Microservices-based architecture
- Independent backend services
- REST API communication
- H2 database for user data
- Docker containerization
- Docker Compose orchestration
- Kubernetes deployment
- Git and GitHub version control
- JavaScript-based frontend

---

## 🔮 Future Enhancements

- User authentication and login
- Persistent database for courses and enrollments
- Student dashboard
- Course search and filtering
- Authentication using JWT
- Automated CI/CD using Jenkins
- Automated API and unit testing