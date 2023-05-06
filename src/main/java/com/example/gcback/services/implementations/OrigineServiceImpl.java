package com.example.gcback.services.implementations;

import com.example.gcback.dto.request.OrigineRequestDto;
import com.example.gcback.dto.response.OrigineResponseDto;
import com.example.gcback.dto.response.UserResponseDto;
import com.example.gcback.entities.Origine;
import com.example.gcback.entities.User;
import com.example.gcback.repositories.OrigineRepo;
import com.example.gcback.services.interfaces.OrigineService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrigineServiceImpl implements OrigineService {

    private final OrigineRepo origineRepo;
    private final ModelMapper modelMapper;




    @Override
    public OrigineResponseDto addNewOrigine(OrigineRequestDto origineRequestDto) {
        Origine origine = modelMapper.map(origineRequestDto, Origine.class);
        Origine origineSaved = origineRepo.save(origine);
        return modelMapper.map(origineSaved, OrigineResponseDto.class);
    }

    @Override
    public OrigineResponseDto getOrigineById(Long id) {
        Origine origine = origineRepo.findById(id).orElseThrow(() -> new RuntimeException("Origine not found"));
        return modelMapper.map(origine, OrigineResponseDto.class);
    }

    @Override
    public List<OrigineResponseDto> listOrigines() {
        return origineRepo.findAll()
                .stream().map(el -> modelMapper.map(el, OrigineResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrigine(Long id) {
        origineRepo.deleteById(id);
    }
}
