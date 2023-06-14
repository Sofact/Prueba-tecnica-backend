package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimientoCuentaPersonaRepository extends JpaRepository<Movimiento, Long> {

    @Query(value = "select m.mov_id, m.cta_id, m.mov_saldo, m.mov_tipo, m.mov_valor, m.mov_fecha, c.cta_estado,  c.cta_tipo_cuenta, c.cta_numero, c.cta_saldo_inicial, p.per_id, p.per_nombre from pc.movimiento m inner join  pc.cuenta c on m.cta_id = c.cta_id inner join pc.persona p on c.per_id = p.per_id", nativeQuery = true)
    List<Object[]> obtenerResultadoJoin();

}