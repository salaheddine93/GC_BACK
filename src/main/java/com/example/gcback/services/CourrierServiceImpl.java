package com.example.gcback.services;

import com.example.gcback.entities.Courrier;
import com.example.gcback.repositories.CourrierRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourrierServiceImpl implements CourrierService{

    private final CourrierRepo courrierRepo;


    @Override
    public Courrier addNewCourrier(Courrier courrier) {
        return courrierRepo.save(courrier);
    }

    @Override
    public Courrier getCourrierById(Long id) {
        return courrierRepo.findById(id).get();
    }

    @Override
    public List<Courrier> listCourriers() {
        return courrierRepo.findAll();
    }

    @Override
    public void deleteCourrier(Long id) {
        courrierRepo.deleteById(id);
    }
}
