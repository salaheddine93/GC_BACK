package com.example.gcback.services.interfaces;

import com.example.gcback.dto.request.OrigineRequestDto;
import com.example.gcback.dto.response.OrigineResponseDto;
import com.example.gcback.entities.Origine;

import java.util.List;


public interface OrigineService {

    OrigineResponseDto addNewOrigine(OrigineRequestDto origineRequestDto);
    OrigineResponseDto getOrigineById(Long id);
    List<OrigineResponseDto> listOrigines();
    void deleteOrigine(Long id);
}
