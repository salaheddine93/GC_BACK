package com.example.gcback.services.implementations;

import com.example.gcback.dto.request.TypeRequestDto;
import com.example.gcback.dto.response.OrigineResponseDto;
import com.example.gcback.dto.response.TypeResponseDto;
import com.example.gcback.dto.response.UserResponseDto;
import com.example.gcback.entities.Origine;
import com.example.gcback.entities.Type;
import com.example.gcback.repositories.TypeRepo;
import com.example.gcback.services.interfaces.TypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepo typeRepo;
    private final ModelMapper modelMapper;




    @Override
    public TypeResponseDto addNewType(TypeRequestDto typeRequestDto) {
       Type type = modelMapper.map(typeRequestDto, Type.class);
       Type typeSaved = typeRepo.save(type);
       return modelMapper.map(typeSaved, TypeResponseDto.class);
    }

    @Override
    public TypeResponseDto getTypeById(Long id) {
        Type type = typeRepo.findById(id).orElseThrow(() -> new RuntimeException("Type not found"));
        return modelMapper.map(type, TypeResponseDto.class);
    }

    @Override
    public List<TypeResponseDto> listTypes() {
        return typeRepo.findAll()
                .stream().map(el -> modelMapper.map(el, TypeResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteType(Long id) {
        typeRepo.deleteById(id);
    }
}
