package com.tfl.assessment.services;

import com.tfl.assessment.repositories.SubjectRepository;

public class SubjectService {

    private SubjectRepository repo = new SubjectRepository();

    public String getAllSubjects() {
        return repo.readSubjectsFromFile();
    }
}
