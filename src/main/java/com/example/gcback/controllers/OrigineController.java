package com.example.gcback.controllers;

import com.example.gcback.dto.request.OrigineRequestDto;
import com.example.gcback.dto.response.OrigineResponseDto;
import com.example.gcback.entities.Origine;
import com.example.gcback.services.interfaces.OrigineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class OrigineController {

    private final OrigineService origineService;

    @GetMapping(path = "/origines")
    public List<OrigineResponseDto> allOrigines(){
        return origineService.listOrigines();
    }

    @PostMapping(path = "/addOrigine")
    public OrigineResponseDto saveOrigine(@RequestBody OrigineRequestDto origineRequestDto){
        return origineService.addNewOrigine(origineRequestDto);
    }

    @DeleteMapping(path = "/origines/{id}")
    public void deleteOrigine(@PathVariable Long id){
        origineService.deleteOrigine(id);
    }
}
