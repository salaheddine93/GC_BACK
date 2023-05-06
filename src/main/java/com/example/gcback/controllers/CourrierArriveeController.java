package com.example.gcback.controllers;

import com.example.gcback.entities.CourrierArrivee;
import com.example.gcback.services.interfaces.CourrierArriveeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/courrierArrivee")
@RequiredArgsConstructor
public class CourrierArriveeController {

    private final CourrierArriveeService courrierService;

    @PostMapping(path = "/addCourrierArrivee")
    public CourrierArrivee saveCourrierArrivee(@RequestBody CourrierArrivee courrierArrivee){
        return courrierService.addNewCourrierArrivee(courrierArrivee);
    }
}
