package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    List<Cuenta> findAll();
    @Override
    Optional<Cuenta> findById(Long ctaId);

    void deleteByCtaId(Long ctaId);
}
