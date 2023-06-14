package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimientoCuentaRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "select m.mov_id, m.cta_id, m.mov_saldo, m.mov_tipo, m.mov_valor, m.mov_fecha, c.cta_numero from movimiento m inner join  cuenta c on m.cta_id = c.cta_id", nativeQuery = true)
    List<Object[]> obtenerResultadoJoin();
}