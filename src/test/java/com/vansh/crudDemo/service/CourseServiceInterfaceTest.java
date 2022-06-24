package com.vansh.crudDemo.service;
import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.repository.CourseRepositoryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceInterfaceTest {
    @Autowired
    private CourseService courseService;
    @MockBean
    private CourseRepositoryInterface courseRepositoryInterface;

    @BeforeEach
    void setUp()
    {
        Course course=Course.builder().courseName("Python").courseDuration("2 months").courseFees("Rs.2,000").build();
        Mockito.when(courseRepositoryInterface.findById(1)).thenReturn(Optional.ofNullable(course));
    }

    @Test
    public void testGetCourse()
    {
        Course c=courseService.getCourse(1);
        assertEquals(1,c.getId());
    }
}