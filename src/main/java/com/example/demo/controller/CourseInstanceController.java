package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CourseInstance;
import com.example.demo.repository.CourseInstanceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController<S> {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @PostMapping
    public CourseInstance createInstance(@RequestBody CourseInstance courseInstance) {
        return courseInstanceRepository.save((Iterable<S>) courseInstance);
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public CourseInstance getInstanceById(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        return courseInstanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Courseinstance not found"));
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public void deleteInstance(@PathVariable int year, @PathVariable int semester, @PathVariable Long id) {
        courseInstanceRepository.deleteById(id);
    }
}
