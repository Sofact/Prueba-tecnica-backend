package com.neoris.pichincha.model;

import java.math.BigDecimal;

public class CuentaPersonaDTO {


    private Long ctaId;


    private BigDecimal ctaNumero;


    private String ctaTipoCuenta;


    private BigDecimal ctaSaldoInicial;


    private String ctaEstado;


    private Long perId;

    private String perNombre;

    public Long getCtaId() {
        return ctaId;
    }

    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    public BigDecimal getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(BigDecimal ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public String getCtaTipoCuenta() {
        return ctaTipoCuenta;
    }

    public void setCtaTipoCuenta(String ctaTipoCuenta) {
        this.ctaTipoCuenta = ctaTipoCuenta;
    }

    public BigDecimal getCtaSaldoInicial() {
        return ctaSaldoInicial;
    }

    public void setCtaSaldoInicial(BigDecimal ctaSaldoInicial) {
        this.ctaSaldoInicial = ctaSaldoInicial;
    }

    public String getCtaEstado() {
        return ctaEstado;
    }

    public void setCtaEstado(String ctaEstado) {
        this.ctaEstado = ctaEstado;
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }
}
