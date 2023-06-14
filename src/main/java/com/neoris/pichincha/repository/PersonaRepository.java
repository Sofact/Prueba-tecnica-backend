package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    List<Persona> findAll();

    Optional<Persona> findByPerId(Long perId);
}
