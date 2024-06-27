package com.spring.jpa.controller;

import com.spring.jpa.model.Automovil;
import com.spring.jpa.model.Persona;
import com.spring.jpa.service.IAutomovilService;
import com.spring.jpa.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.IDN;
import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService persoser;

    @Autowired
    private IAutomovilService autoser;

    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return persoser.getPersonas();
    }

    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona p){
        Automovil auto = p.getAutomovil();
        // Guardar primero el automovil
        if (p.getAutomovil() != null) {
            autoser.saveAutomovil(p.getAutomovil());
            p.setAutomovil(auto);

        }
        // Guardar la persona

        persoser.savePersona(p);

        return "Persona creada perfectamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){

        persoser.deletePersona(id);
        return "Persona borrada perfectamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam(required = false, name ="id") Long idn,
                                @RequestParam(required = false, name ="nombre") String nombre,
                                @RequestParam(required = false, name ="apellidos") String apellidos,
                                @RequestParam(required = false, name ="edad") int edad,
                                 @RequestParam(required = false, name ="automovil") Automovil automovil)
    {
       persoser.editPersona(id, idn, nombre, apellidos, edad, automovil);

       Persona p = persoser.findPersona(idn);

       return p;

    }

    @PutMapping("/personas/editar")
    public Persona editarPersona(@RequestBody Persona pe)
    {
        persoser.editPersona(pe);

        return  persoser.findPersona(pe.getId());

    }

}
