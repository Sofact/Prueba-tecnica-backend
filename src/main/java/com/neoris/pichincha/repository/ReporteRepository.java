package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReporteRepository extends JpaRepository<Movimiento, Long> {



    @Query(value = "SELECT p.per_id, p.per_nombre, ct.cta_id, ct.cta_estado, ct.cta_numero, ct.cta_saldo_inicial, ct.cta_tipo_cuenta, " +
            "SUM(CASE WHEN m.mov_tipo = 'Deposito' THEN m.mov_valor ELSE 0 END) AS total_creditos, " +
            "SUM(CASE WHEN m.mov_tipo = 'Retiro' THEN m.mov_valor ELSE 0 END) AS total_debitos, m.mov_saldo " +
            "FROM persona p " +
            "INNER JOIN cuenta ct ON p.per_id = ct.per_id " +
            "INNER JOIN movimiento m ON m.cta_id = ct.cta_id " +
            "WHERE m.mov_fecha BETWEEN ?1 AND ?2 and p.per_id = ?3 " +
            "GROUP BY p.per_id, p.per_nombre, ct.cta_id, ct.cta_estado, ct.cta_numero, ct.cta_saldo_inicial, ct.cta_tipo_cuenta, m.mov_saldo", nativeQuery = true)
    List<Object[]> obtenerResultadoJoin(Date fechaInicio, Date fechaFin, Long opcionSeleccionada);

}
