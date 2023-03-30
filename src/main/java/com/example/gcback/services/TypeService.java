package com.example.gcback.services;

import com.example.gcback.entities.Type;

import java.util.List;


public interface TypeService {

    Type addNewType(Type type);
    Type getTypeById(Long id);
    List<Type> listTypes();
    void deleteType(Long id);
}
