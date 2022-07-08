package com.vansh.crudDemo.controller;

import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.service.CourseServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Api(tags = "My-Course-Controller")
public class CourseController {
    @Autowired
    private CourseServiceInterface courseServiceInterface;

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("/")
    @ApiOperation(value = "Get all courses details")
    public ResponseEntity<List<Course>> getAllCourse() {
        logger.trace("Calling and starting getAllCourse()");
        List<Course> courses;
        try {
            courses = courseServiceInterface.getAllCourse();
            return new ResponseEntity<>(courses, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.error("Error in getAllCourse() endpoint :" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get course details by id")
    public ResponseEntity<Course> getCourse(@PathVariable int id) {
        logger.info("Calling and starting getCourse()");
        Course course;
        try {
            course = courseServiceInterface.getCourse(id);
            return new ResponseEntity<>(course, HttpStatus.FOUND);
        } catch (Exception e) {
            logger.error("Error in getCourse() endpoint :" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/")
    @ApiOperation(value = "Add course details")
    public ResponseEntity<Course> addCourse(@RequestBody Course c) {
        logger.info("Calling and starting addCourse()");
        Course course;
        try {
            course = courseServiceInterface.addCourse(c);
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error in addCourse() endpoint :" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Update course details by id")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course c) {
        logger.info("Calling and starting updateCourse()");
        Course course;
        try {
            course = courseServiceInterface.updateCourse(id, c);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in updateCourse() endpoint :" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete course details by id")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        logger.info("Calling and starting deleteCourse()");
        try {
            courseServiceInterface.deleteCourse(id);
            return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in deleteCourse() endpoint :" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
