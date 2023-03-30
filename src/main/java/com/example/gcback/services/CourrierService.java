package com.example.gcback.services;

import com.example.gcback.entities.Courrier;
import java.util.List;


public interface CourrierService {

    Courrier addNewCourrier(Courrier courrier);
    Courrier getCourrierById(Long id);
    List<Courrier> listCourriers();
    void deleteCourrier(Long id);
}
