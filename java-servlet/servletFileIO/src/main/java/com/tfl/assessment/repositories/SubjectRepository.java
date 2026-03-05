package com.tfl.assessment.repositories;

import java.io.InputStream;

public class SubjectRepository {

    public String readSubjectsFromFile() {
        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("data/subjects.json")) {

            return new String(is.readAllBytes());
        } catch (Exception e) {
            return "[]";
        }
    }
}
