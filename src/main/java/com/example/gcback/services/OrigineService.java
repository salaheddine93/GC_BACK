package com.example.gcback.services;

import com.example.gcback.entities.Origine;

import java.util.List;


public interface OrigineService {

    Origine addNewOrigine(Origine origine);
    Origine getOrigineById(Long id);
    List<Origine> listOrigines();
    void deleteOrigine(Long id);
}
