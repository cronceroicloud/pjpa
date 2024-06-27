package com.spring.jpa.service;

import com.spring.jpa.model.Automovil;
import com.spring.jpa.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona p);
    public void deletePersona( Long id);
    public Persona findPersona(Long id);
    public void editPersona (Long ido, Long idn, String nombre, String apellidos, int edad, Automovil auto);

    public void editPersona (Persona p);



}