package com.neoris.pichincha.service;


import com.neoris.pichincha.model.Cuenta;
import com.neoris.pichincha.repository.ClienteRepository;
import com.neoris.pichincha.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService( CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> getAll(){

        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long ctaId){

        return cuentaRepository.findById(ctaId);
    }

    @Transactional
    public Cuenta saveCuenta(Cuenta cuenta){

        return  cuentaRepository.save(cuenta);
    }

    @Transactional
    public Cuenta updateCuenta(Optional<Cuenta> cuenta){

        if (cuenta.isPresent()) {

            return cuentaRepository.save(cuenta.get());
        } else {
            throw new RuntimeException("Cuenta no encontrada");
        }
    }

    @Transactional
    public void deleteByCtaId(Long ctaId){
        cuentaRepository.deleteByCtaId(ctaId);
    }
}
