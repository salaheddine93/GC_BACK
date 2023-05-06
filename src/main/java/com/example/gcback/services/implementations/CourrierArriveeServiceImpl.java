package com.example.gcback.services.implementations;

import com.example.gcback.entities.Courrier;
import com.example.gcback.entities.CourrierArrivee;
import com.example.gcback.repositories.CourrierRepo;
import com.example.gcback.services.interfaces.CourrierArriveeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CourrierArriveeServiceImpl implements CourrierArriveeService {

    private final CourrierRepo courrierRepo;


    @Override
    public CourrierArrivee addNewCourrierArrivee(CourrierArrivee courrierArrivee) {
        return courrierRepo.save(courrierArrivee);
    }

    @Override
    public CourrierArrivee getCourrierArriveeById(Long id) {
        return (CourrierArrivee) courrierRepo.findById(id).get();
    }

    @Override
    public List<Courrier> listCourriersArrivee() {
        return courrierRepo.findAll();
    }

    @Override
    public void deleteCourrierArrivee(Long id) {
        courrierRepo.deleteById(id);
    }
}
