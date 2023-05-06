package com.example.gcback.services.interfaces;

import com.example.gcback.dto.request.TypeRequestDto;
import com.example.gcback.dto.response.TypeResponseDto;
import com.example.gcback.entities.Type;

import java.util.List;


public interface TypeService {

    TypeResponseDto addNewType(TypeRequestDto typeRequestDto);
    TypeResponseDto getTypeById(Long id);
    List<TypeResponseDto> listTypes();
    void deleteType(Long id);
}
