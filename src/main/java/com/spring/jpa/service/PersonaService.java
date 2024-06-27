package com.spring.jpa.service;

import com.spring.jpa.model.Automovil;
import com.spring.jpa.model.Persona;
import com.spring.jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersonaRepository persorepo;
    @Override
    public List<Persona> getPersonas() {
        return persorepo.findAll();
    }

    @Override
    public void savePersona(Persona p) {


      /* if (persorepo.findById(p.getAutomovil().getId()).isPresent()){
            System.out.println("edita el automovil");
            new AutomovilService().editAutomovil(p.getAutomovil().getId(),p.getAutomovil().getId(),p.getAutomovil().getMarca(),p.getAutomovil().getModelo(), p.getAutomovil().getKm(),p.getAutomovil().getAno());

        }else {
           System.out.println("crea un nuevo automovil");
            new AutomovilService().saveAutomovil(p.getAutomovil());

        }
        System.out.println("hola");*/
        persorepo.save(p);

    }

    @Override
    public void deletePersona(Long id) {
        persorepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona p= (Persona) persorepo.findById(id).orElse(null);
        return p;
    }
    @Override
    public void editPersona (Long ido, Long idn, String nombre, String apellidos, int edad, Automovil automovil) {
        Persona p= this.findPersona(ido);
        p.setId(idn);
        p.setNombre(nombre);
        p.setApellidos(apellidos);
        p.setEdad(edad);
        p.setAutomovil(automovil);

        persorepo.save(p);
    }

    @Override
    public void editPersona (Persona p) {
        persorepo.save(p);
    }
}

