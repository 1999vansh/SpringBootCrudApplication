package com.vansh.crudDemo.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//Using Lombok @Data to include Getters, Setters, toString() method
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    //@Id to declare primary key and @GeneratedValue(...) to auto increment primary key value like 1,2,3...
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String courseName;
    private String courseFees;
    private String courseDuration;
}
