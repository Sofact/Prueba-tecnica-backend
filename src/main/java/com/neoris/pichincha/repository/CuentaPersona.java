package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaPersona extends JpaRepository<Persona, Long> {

    @Query(value = "SELECT c.cta_id, c.cta_estado, c.cta_numero, c.cta_saldo_inicial, c.cta_tipo_cuenta, c.per_id, p.per_nombre FROM cuenta c INNER JOIN persona p ON c.per_id = p.per_id", nativeQuery = true)
    List<Object[]> obtenerResultadoJoin();
}


