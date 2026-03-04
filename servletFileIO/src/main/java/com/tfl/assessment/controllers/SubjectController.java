package com.tfl.assessment.controllers;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.tfl.assessment.services.SubjectService;

@WebServlet("/subjects")
public class SubjectController extends HttpServlet {

    private SubjectService service = new SubjectService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("application/json");
        resp.getWriter().write(service.getAllSubjects());
    }
}
