const USER_SERVICE = "https://learnhub-user-service.onrender.com";
const COURSE_SERVICE = "https://learnhub-course-service.onrender.com";
const ENROLLMENT_SERVICE = "https://learnhub-enrollment-service.onrender.com";


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
    const list = document.getElementById("courseList");

    if (!list) return;

    list.innerHTML = "<p>Loading courses...</p>";

    try {
        const response = await fetch(COURSE_SERVICE + "/courses");

        if (!response.ok) {
            throw new Error("Server returned " + response.status);
        }

        const courses = await response.json();
        list.innerHTML = "";

        if (!Array.isArray(courses) || courses.length === 0) {
            list.innerHTML = `
                <div class="course-card">
                    <h3>No courses yet</h3>
                    <p>Add a course using the form below to get started.</p>
                </div>
            `;
            return;
        }

        courses.forEach(course => {
            const card = document.createElement("article");
            card.className = "course-card";

            const title = document.createElement("h3");
            title.textContent = course.title || "Untitled course";

            const instructor = document.createElement("p");
            instructor.textContent =
                "Instructor: " + (course.instructor || "Not specified");

            const description = document.createElement("p");
            description.textContent =
                course.description || "No description provided.";

            const button = document.createElement("button");
            button.textContent = "Enroll";
            button.addEventListener("click", () => enroll(course.id));

            card.append(title, instructor, description, button);
            list.appendChild(card);
        });

    } catch (error) {
        console.error("Unable to load courses:", error);

        list.innerHTML = `
            <div class="course-card">
                <h3>Courses couldn't load</h3>
                <p>Check that Course Service is running on port 8082.</p>
                <button onclick="loadCourses()">Try again</button>
            </div>
        `;
    }
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