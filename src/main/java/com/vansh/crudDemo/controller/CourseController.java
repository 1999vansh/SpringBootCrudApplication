package com.vansh.crudDemo.controller;
import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.service.CourseServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Api(tags = "My-Course-Controller")
public class CourseController {
    @Autowired
    private CourseServiceInterface courseServiceInterface;

    //Controller to Get all courses list
    @GetMapping("/")
    @ApiOperation(value = "Get all courses details")
    public List<Course> getAllCourse()
    {
        return courseServiceInterface.getAllCourse();
    }

    //Controller to get a course by Id
    @GetMapping("/{id}")
    @ApiOperation(value = "Get course details by id")
    public Course getCourse(@PathVariable int id)
    {
        return courseServiceInterface.getCourse(id);
    }

    //Controller to Add a new Course
    @PostMapping("/")
    @ApiOperation(value = "Add course details")
    public Course addCourse(@RequestBody Course c)
    {
        return courseServiceInterface.addCourse(c);
    }

    //Controller to Update a Course by Id
    @PutMapping("/{id}")
    @ApiOperation(value = "Update course details by id")
    public Course updateCourse(@PathVariable int id,@RequestBody Course c)
    {
        return courseServiceInterface.updateCourse(id,c);
    }

    //Controller to Delete a Course by Id
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete course details by id")
    public String deleteCourse(@PathVariable int id)
    {
        courseServiceInterface.deleteCourse(id);
        return "Course Deleted Successfully";
    }
}
