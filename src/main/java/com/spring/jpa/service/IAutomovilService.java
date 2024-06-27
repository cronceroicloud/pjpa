package com.spring.jpa.service;

import com.spring.jpa.model.Automovil;


import java.util.List;


public interface IAutomovilService {

    public List<Automovil> getAutomovil();
    public void saveAutomovil(Automovil a);
    public void deleteAutomovil( Long id);
    public Automovil findAutomovil(Long id);
    public void editAutomovil (Long ido, Long idn, String marca, String modelo, int km,int ano);
}
