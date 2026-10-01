const USER_SERVICE = "http://localhost:8081";
const COURSE_SERVICE = "http://localhost:8082";
const ENROLLMENT_SERVICE = "http://localhost:8083";


function showRegister() {
    document.getElementById("registerSection").scrollIntoView();
}


async function registerUser() {

    const user = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    const response = await fetch(
        USER_SERVICE + "/users/register",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        }
    );

    if (response.ok) {
        document.getElementById("registerMessage").innerText =
            "Registration successful!";
    } else {
        document.getElementById("registerMessage").innerText =
            "Registration failed.";
    }
}


async function loadCourses() {

    const response = await fetch(
        COURSE_SERVICE + "/courses"
    );

    const courses = await response.json();

    const list = document.getElementById("courseList");

    list.innerHTML = "";

    courses.forEach(course => {

        list.innerHTML += `
            <div class="course-card">
                <h3>${course.title}</h3>
                <p><strong>Instructor:</strong> ${course.instructor}</p>
                <p>${course.description}</p>

                <button onclick="enroll(${course.id})">
                    Enroll
                </button>
            </div>
        `;
    });
}


async function addCourse() {

    const course = {
        title: document.getElementById("courseTitle").value,
        instructor: document.getElementById("instructor").value,
        description: document.getElementById("description").value
    };

    await fetch(
        COURSE_SERVICE + "/courses",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(course)
        }
    );

    loadCourses();
}


async function enroll(courseId) {

    const enrollment = {
        studentId: 1,
        courseId: courseId
    };

    const response = await fetch(
        ENROLLMENT_SERVICE + "/enrollments",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(enrollment)
        }
    );

    if (response.ok) {
        alert("Successfully enrolled!");
    }
}


if (document.getElementById("courseList")) {
    loadCourses();
}