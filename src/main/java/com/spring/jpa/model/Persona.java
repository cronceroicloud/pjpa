package com.spring.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    @OneToOne
    @JoinColumn(name = " automovil_id", referencedColumnName = "id")
    private Automovil automovil;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellidos, int edad, Automovil automovil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.automovil=automovil;
    }
}
