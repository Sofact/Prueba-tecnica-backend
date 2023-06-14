package com.neoris.pichincha.service;

import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.model.MovimientoCuentaDTO;
import com.neoris.pichincha.repository.MovimientoCuentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovimientoCuentaService {

    private final MovimientoCuentaRepository movimientoCuentaRepository;

    public MovimientoCuentaService(MovimientoCuentaRepository movimientoCuentaRepository) {
        this.movimientoCuentaRepository = movimientoCuentaRepository;
    }

    public List<MovimientoCuentaDTO> obtenerResultadoJoin() {
        List<Object[]> resultados = movimientoCuentaRepository.obtenerResultadoJoin();
        List<MovimientoCuentaDTO> movimientoCuenta = new ArrayList<>();

        for (Object[] resultado : resultados) {
            MovimientoCuentaDTO movimientoCuentaDTO = new MovimientoCuentaDTO();
            movimientoCuentaDTO.setMovId((Long) resultado[0]);
            movimientoCuentaDTO.setCtaId((Long) resultado[1]);
            movimientoCuentaDTO.setMovSaldo((Long) resultado[2]);
            movimientoCuentaDTO.setMovTipo((String) resultado[3]);
            movimientoCuentaDTO.setMovValor((Long) resultado[4]);
            movimientoCuentaDTO.setMovfecha((Date) resultado[5]);
            movimientoCuentaDTO.setCtaNumero((Long) resultado[6]);

            movimientoCuenta.add(movimientoCuentaDTO);
        }

        return movimientoCuenta;
    }
}
