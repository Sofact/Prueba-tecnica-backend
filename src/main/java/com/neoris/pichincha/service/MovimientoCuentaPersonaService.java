package com.neoris.pichincha.service;

import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.model.MovimientoCuentaPersonaDTO;
import com.neoris.pichincha.repository.MovimientoCuentaPersonaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MovimientoCuentaPersonaService {

    private final MovimientoCuentaPersonaRepository movimientoCuentaPersonaRepository;

    public MovimientoCuentaPersonaService(MovimientoCuentaPersonaRepository movimientoCuentaPersonaRepository) {
        this.movimientoCuentaPersonaRepository = movimientoCuentaPersonaRepository;
    }


    public List<MovimientoCuentaPersonaDTO> obtenerResultadoJoin() {
        List<Object[]> resultados = movimientoCuentaPersonaRepository.obtenerResultadoJoin();
        List<MovimientoCuentaPersonaDTO> movimientoCuentasPersonas = new ArrayList<>();

        for (Object[] resultado : resultados) {
            MovimientoCuentaPersonaDTO movimientoCuentaPersonaDTO = new MovimientoCuentaPersonaDTO();
            movimientoCuentaPersonaDTO.setMovId((Long) resultado[0]);
            movimientoCuentaPersonaDTO.setCtaId((Long) resultado[1]);
            movimientoCuentaPersonaDTO.setMovSaldo((Long) resultado[2]);
            movimientoCuentaPersonaDTO.setMovTipo((String) resultado[3]);
            movimientoCuentaPersonaDTO.setMovValor((Long) resultado[4]);
            movimientoCuentaPersonaDTO.setMovfecha((Date) resultado[5]);
            movimientoCuentaPersonaDTO.setMovEstado((String) resultado[6]);
            movimientoCuentaPersonaDTO.setCtaTipoCuenta((String) resultado[7]);
            movimientoCuentaPersonaDTO.setCtaNumero((Long) resultado[8]);
            movimientoCuentaPersonaDTO.setCtaSaldoInicial((Long) resultado[9]);
            movimientoCuentaPersonaDTO.setPerId((Long) resultado[10]);
            movimientoCuentaPersonaDTO.setPerNombre((String) resultado[11]);

            movimientoCuentasPersonas.add(movimientoCuentaPersonaDTO);
        }

        return movimientoCuentasPersonas;
    }
}
