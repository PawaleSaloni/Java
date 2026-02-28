package com.docker.demo.students.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.docker.demo.students.Entity.Student;

public interface  IStudentService {
    CompletableFuture<Boolean> create(String name ,String email);
    CompletableFuture<Boolean> update(String name,int id);
    CompletableFuture<List<String>> display();
    CompletableFuture<Boolean> delete(int id);
    CompletableFuture<Student> getById(int id);
}
