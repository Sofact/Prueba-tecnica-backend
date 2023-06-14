package com.neoris.pichincha.service;

import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.repository.CuentaPersona;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaPersonaService {
    private final CuentaPersona cuentaPersonaRepository;

    public CuentaPersonaService(CuentaPersona cuentaPersonaRepository) {
        this.cuentaPersonaRepository = cuentaPersonaRepository;
    }

    public List<CuentaPersonaDTO> obtenerResultadoJoin() {
        List<Object[]> resultados = cuentaPersonaRepository.obtenerResultadoJoin();
        List<CuentaPersonaDTO> cuentasPersonas = new ArrayList<>();

        for (Object[] resultado : resultados) {
            CuentaPersonaDTO cuentaPersonaDTO = new CuentaPersonaDTO();
            cuentaPersonaDTO.setCtaId((Long) resultado[0]);
            cuentaPersonaDTO.setCtaEstado((String) resultado[1]);
            cuentaPersonaDTO.setCtaNumero(BigDecimal.valueOf((Long) resultado[2]));
            cuentaPersonaDTO.setCtaSaldoInicial(BigDecimal.valueOf((Long) resultado[3]));
            cuentaPersonaDTO.setCtaTipoCuenta((String) resultado[4]);
            cuentaPersonaDTO.setPerId((Long) resultado[5]);
            cuentaPersonaDTO.setPerNombre((String) resultado[6]);

            cuentasPersonas.add(cuentaPersonaDTO);
        }

        return cuentasPersonas;
    }
}
