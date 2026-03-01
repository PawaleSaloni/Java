package com.docker.demo.students.Repository;

import java.util.List;

import com.docker.demo.students.Entity.Student;

public interface IStudentRepository {
    boolean create(String name,String email);
    boolean update(String name,int id);
    List<String> display();
    boolean delete(int id);
    Student getById(int id);
}
