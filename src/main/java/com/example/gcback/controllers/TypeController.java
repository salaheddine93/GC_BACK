package com.example.gcback.controllers;

import com.example.gcback.dto.request.TypeRequestDto;
import com.example.gcback.dto.response.TypeResponseDto;
import com.example.gcback.services.interfaces.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping(path = "/types")
    public List<TypeResponseDto> allTypes(){
        return typeService.listTypes();
    }

    @PostMapping(path = "/addType")
    public TypeResponseDto saveType(@RequestBody TypeRequestDto typeRequestDto){
        return typeService.addNewType(typeRequestDto);
    }

    @DeleteMapping(path = "/types/{id}")
    public void deleteType(@PathVariable Long id){
        typeService.deleteType(id);
    }
}
