package com.spring.jpa.service;

import com.spring.jpa.model.Automovil;
import com.spring.jpa.model.Persona;
import com.spring.jpa.repository.IAutomovilRepository;
import com.spring.jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovilService implements IAutomovilService {

    @Autowired
    private IAutomovilRepository autorepo;
    @Override
    public List<Automovil> getAutomovil() {
        return autorepo.findAll();
    }

    @Override
    public void saveAutomovil(Automovil a) {
        autorepo.save(a);
    }

    @Override
    public void deleteAutomovil(Long id) {
        autorepo.deleteById(id);
    }

    @Override
    public Automovil findAutomovil(Long id) {
        Automovil a= (Automovil) autorepo.findById(id).orElse(null);
        return a;
    }

    @Override
    public void editAutomovil(Long ido, Long idn, String marca, String modelo, int km, int ano) {

        Automovil a= this.findAutomovil(ido);
        a.setId(idn);
        a.setMarca(marca);
        a.setModelo(modelo);
        a.setKm(km);
        a.setAno(ano);

        autorepo.save(a);

    }
}
