package com.spring.jpa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String marca;
    private String modelo;
    private int km;
    private int ano;

    public Automovil(Long id, String marca, String modelo, int km, int ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
        this.ano = ano;
    }

    public Automovil() {
    }


}
