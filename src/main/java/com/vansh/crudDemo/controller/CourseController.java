package com.vansh.crudDemo.controller;
import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.service.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseServiceInterface courseServiceInterface;

    //Controller to Get all courses list
    @GetMapping("/courses")
    public List<Course> getAllCourse()
    {
        return courseServiceInterface.getAllCourse();
    }

    //Controller to get a course by Id
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id)
    {
        return courseServiceInterface.getCourse(id);
    }

    //Controller to Add a new Course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course c)
    {
        return courseServiceInterface.addCourse(c);
    }

    //Controller to Update a Course by Id
    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id,@RequestBody Course c)
    {
        return courseServiceInterface.updateCourse(id,c);
    }

    //Controller to Delete a Course by Id
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id)
    {
        courseServiceInterface.deleteCourse(id);
        return "Course Deleted Successfully";
    }
}
