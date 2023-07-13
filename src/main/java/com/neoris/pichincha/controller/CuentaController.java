package com.neoris.pichincha.controller;

import com.neoris.pichincha.model.Cuenta;
import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.service.CuentaPersonaService;
import com.neoris.pichincha.service.CuentaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private CuentaPersonaService cuentaPersonaService;

    @GetMapping("/all")
    public List<CuentaPersonaDTO> getAll(){

        return cuentaPersonaService.obtenerResultadoJoin();
    }

    @GetMapping("/id/{ctaId}")
    public Cuenta getById(@PathVariable Long ctaId){

        return cuentaService.findById(ctaId).orElse(null);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta create (@RequestBody Cuenta cuenta) {

        return cuentaService.saveCuenta(cuenta);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cuenta update(@RequestBody Cuenta cuenta, @PathVariable Long id){

        Optional<Cuenta> cuentaActual = cuentaService.findById(id);

        cuentaActual.orElse(null).setCtaNumero(cuenta.getCtaNumero());
        cuentaActual.orElse(null).setCtaTipoCuenta(cuenta.getCtaTipoCuenta());
        cuentaActual.orElse(null).setCtaSaldoInicial(cuenta.getCtaSaldoInicial());
        cuentaActual.orElse(null).setCtaEstado(cuenta.getCtaEstado());
        cuentaActual.orElse(null).setPerId(cuenta.getPerId());

        return cuentaService.updateCuenta(cuentaActual);
    }

    @DeleteMapping("/del/{ctaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public Long delete (@PathVariable long ctaId){

        cuentaService.deleteByCtaId(ctaId);
        return ctaId;
    }
}
