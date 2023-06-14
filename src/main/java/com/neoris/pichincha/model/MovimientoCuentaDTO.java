package com.neoris.pichincha.model;

import jakarta.persistence.Column;

import java.util.Date;

public class MovimientoCuentaDTO {

    private Long movId;

    private Date movfecha;

    private String movTipo;

    private Long movValor;

    private Long movSaldo;

    private Long ctaId;

    private Long ctaNumero;

    public Long getMovId() {
        return movId;
    }

    public void setMovId(Long movId) {
        this.movId = movId;
    }

    public Date getMovfecha() {
        return movfecha;
    }

    public void setMovfecha(Date movfecha) {
        this.movfecha = movfecha;
    }

    public String getMovTipo() {
        return movTipo;
    }

    public void setMovTipo(String movTipo) {
        this.movTipo = movTipo;
    }

    public Long getMovValor() {
        return movValor;
    }

    public void setMovValor(Long movValor) {
        this.movValor = movValor;
    }

    public Long getMovSaldo() {
        return movSaldo;
    }

    public void setMovSaldo(Long movSaldo) {
        this.movSaldo = movSaldo;
    }

    public Long getCtaId() {
        return ctaId;
    }

    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    public Long getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(Long ctaNumero) {
        this.ctaNumero = ctaNumero;
    }
}
