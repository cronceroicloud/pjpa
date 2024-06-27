package com.spring.jpa.controller;

import com.spring.jpa.model.Automovil;
import com.spring.jpa.model.Persona;
import com.spring.jpa.service.IAutomovilService;
import com.spring.jpa.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AutomovilController {

    @Autowired
    private IAutomovilService autoser;


    @PostMapping("/automovil/crear")
    public String saveAutomovil(@RequestBody Automovil auto){
        autoser.saveAutomovil(auto);
        return "Automovil creado perfectamente";
    }

}
