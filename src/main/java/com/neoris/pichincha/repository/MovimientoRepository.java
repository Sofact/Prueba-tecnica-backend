package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Cuenta;
import com.neoris.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {


    List<Movimiento> findAll();
    @Override
    Optional<Movimiento> findById(Long movId);

    void deleteByMovId(Long movId);
}
