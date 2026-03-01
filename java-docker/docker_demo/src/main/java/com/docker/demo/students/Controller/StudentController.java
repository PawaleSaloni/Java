package com.docker.demo.students.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docker.demo.students.Entity.Student;
import com.docker.demo.students.Service.IStudentService;

@RestController
public class StudentController {
   
    private IStudentService service;

    public StudentController(IStudentService service){
        this.service=service;
    }

    //@GetMapping("/")
    //public String show() { 
      //return "<h1>Welcome to Student Info page</h1>";
    //}

    @PostMapping("/insert")
    public CompletableFuture<Boolean> insert(@RequestParam String name,@RequestParam String email){
               return service.create(name,email);

    }

    @PostMapping("/update")
    public CompletableFuture<Boolean> update(@RequestParam String name,@RequestParam int id){
        return service.update(name,id);
    }

    @DeleteMapping("/delete")
    public CompletableFuture<Boolean> delete(@RequestParam int id){
        return service.delete(id);
    }

    @GetMapping("/display")
    public CompletableFuture<List<String>> display() {
        return service.display(); 
    }

    @GetMapping("/id/{id}")
    public CompletableFuture<Student> getById(@PathVariable("id") int id){
        return service.getById(id);
    }
}
