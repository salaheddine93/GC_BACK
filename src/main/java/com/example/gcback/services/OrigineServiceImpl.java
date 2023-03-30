package com.example.gcback.services;

import com.example.gcback.entities.Origine;
import com.example.gcback.repositories.OrigineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrigineServiceImpl implements OrigineService{

    private final OrigineRepo origineRepo;

    @Override
    public Origine addNewOrigine(Origine origine) {
        return origineRepo.save(origine);
    }

    @Override
    public Origine getOrigineById(Long id) {
        return origineRepo.findById(id).get();
    }

    @Override
    public List<Origine> listOrigines() {
        return origineRepo.findAll();
    }

    @Override
    public void deleteOrigine(Long id) {
        origineRepo.deleteById(id);
    }
}
