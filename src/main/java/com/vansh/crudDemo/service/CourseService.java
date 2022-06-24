package com.vansh.crudDemo.service;
import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.repository.CourseRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {
    @Autowired
    private CourseRepositoryInterface courseRepository;
    @Override
    public Course addCourse(Course c) {
        return courseRepository.save(c);
    }
    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    @Override
    public Course getCourse(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(int id,Course c) {
        Course obj=courseRepository.findById(id).get();
        obj.setCourseName(c.getCourseName());
        obj.setCourseDuration(c.getCourseDuration());
        obj.setCourseFees(c.getCourseFees());
        return courseRepository.save(obj);
    }
}
