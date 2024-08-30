// src/components/CoursesList.js
import React, { useEffect, useState } from 'react';

const CoursesList = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    // Fetch the list of courses from the Spring Boot API
    fetch('/api/courses')
      .then((response) => response.json())
      .then((data) => setCourses(data))
      .catch((error) => console.error('Error fetching courses:', error));
  }, []);

  return (
    <div>
      <h1>Courses List</h1>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            {course.title} - {course.code}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CoursesList;
