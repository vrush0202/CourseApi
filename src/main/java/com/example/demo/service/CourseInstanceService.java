package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.CourseInstance;
import com.example.demo.repository.CourseInstanceRepository;

@Service
public class CourseInstanceService {

    private final CourseInstanceRepository courseInstanceRepository = null;

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        return courseInstanceRepository.saveAll(courseInstance);
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public Course getCourseInstance(Long id) {
        return courseInstanceRepository.findById(id).orElse(null);
    }
    

    public void deleteCourseInstance(Long id) {
        courseInstanceRepository.deleteById(id);
    }
}
