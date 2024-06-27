package com.spring.jpa.repository;

import com.spring.jpa.model.Automovil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutomovilRepository extends JpaRepository<Automovil, Long> {
}
