package com.hibernate.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // -------- INSERT DATA --------
        Course course = new Course();
        course.setCourseId(2);
        course.setTitle("Java");

        Student student = new Student();
        student.setId(2);
        student.setName("Tejas");
        student.setMarks(90.0);

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        student.setCourses(courses);

        session.persist(course);
        session.persist(student);

        tx.commit();   // Save to DB

        // -------- QUERY --------
        session.beginTransaction();

        String hql = "SELECT s FROM Student s JOIN s.courses c WHERE c.title = :courseTitle";

        Query<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("courseTitle", "Java");

        List<Student> students = query.getResultList();

        System.out.println("Students enrolled in Java:");

        for (Student s : students) {
            System.out.println("ID: " + s.getId() + " Name: " + s.getName());
        }

        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}