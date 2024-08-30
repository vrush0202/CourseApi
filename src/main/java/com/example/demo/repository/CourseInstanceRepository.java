package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Course;
import com.example.demo.model.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<Course, Long> {

	List<CourseInstance> findByYearAndSemester(int year, int semester);



	}


