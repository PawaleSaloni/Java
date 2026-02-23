package com.tap.saloni.Repository.Interface;

public interface ITflMentoringRepo {

    boolean insert(int id, String title, String Url, int repoid);
    
    void getAll();

}