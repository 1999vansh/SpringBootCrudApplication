package com.vansh.crudDemo.service;
import com.vansh.crudDemo.entity.Course;
import com.vansh.crudDemo.repository.CourseRepositoryInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CourseServiceTest {
    @MockBean
    private CourseRepositoryInterface courseRepositoryInterface;
    @Autowired
    private CourseService courseService;

    @Test
    public void testAddCourse(){
        Course expectedResult=new Course(1,"Core Java","Rs. 2000","2 months");
        when(courseRepositoryInterface.save(any())).thenReturn(expectedResult);
        Course actualResult=courseService.addCourse(expectedResult);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetAllCourse(){
        List<Course> expectedResult=new ArrayList<>();
        Course course=new Course(1,"Core Java","Rs. 2000","2 months");
        Course course1=new Course(2,"NodeJs","Rs. 1000","1 month");
        expectedResult.add(course);
        expectedResult.add(course1);
        when(courseRepositoryInterface.findAll()).thenReturn(expectedResult);
        List<Course> actualResult=courseService.getAllCourse();
        assertEquals(expectedResult.size(),actualResult.size());
    }

    @Test
    public void testGetCourse(){
        Course expectedResult=new Course(1,"Core Java","Rs. 2000","2 months");
        when(courseRepositoryInterface.findById(any())).thenReturn(Optional.of(expectedResult));
        Course actualResult=courseService.getCourse(1);
        assertEquals(expectedResult.getId(),actualResult.getId());
    }

    @Test
    public void testUpdateCourse(){
        Course expectedResult=new Course(1,"Core Java","Rs. 2000","2 months");
        when(courseRepositoryInterface.findById(any())).thenReturn(Optional.of(expectedResult));
        when(courseRepositoryInterface.save(any())).thenReturn(expectedResult);
        Course actualResult=courseService.getCourse(1);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testDeleteCourse(){
        Course course=new Course(1,"Core Java","Rs. 2000","2 months");
        courseService.deleteCourse(course.getId());
        verify(courseRepositoryInterface,times(1)).deleteById(course.getId());
    }
}
