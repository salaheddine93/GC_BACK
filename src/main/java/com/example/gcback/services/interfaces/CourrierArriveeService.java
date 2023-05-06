package com.example.gcback.services.interfaces;

import com.example.gcback.entities.Courrier;
import com.example.gcback.entities.CourrierArrivee;

import java.util.List;


public interface CourrierArriveeService {

    CourrierArrivee addNewCourrierArrivee(CourrierArrivee courrierArrivee);
    CourrierArrivee getCourrierArriveeById(Long id);
    List<Courrier> listCourriersArrivee();
    void deleteCourrierArrivee(Long id);
}
