package com.example.gcback.services;

import com.example.gcback.entities.Type;
import com.example.gcback.repositories.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService{

    private final TypeRepo typeRepo;

    @Override
    public Type addNewType(Type type) {
        return typeRepo.save(type);
    }

    @Override
    public Type getTypeById(Long id) {
        return typeRepo.findById(id).get();
    }

    @Override
    public List<Type> listTypes() {
        return typeRepo.findAll();
    }

    @Override
    public void deleteType(Long id) {
        typeRepo.deleteById(id);
    }
}
