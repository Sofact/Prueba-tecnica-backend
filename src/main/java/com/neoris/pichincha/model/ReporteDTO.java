package com.neoris.pichincha.model;

import java.math.BigDecimal;

public class ReporteDTO {

    private Long perId;
    private String perNombre;
    private Long ctaId;
    private String ctaEstado;
    private Long ctaNumero;
    private Long ctaSaldoInicial;
    private String ctaTipoCuenta;
    private BigDecimal totalCreditos;
    private BigDecimal totalDebitos;
    private Long movSaldo;

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

    public Long getCtaId() {
        return ctaId;
    }

    public void setCtaId(Long ctaId) {
        this.ctaId = ctaId;
    }

    public String getCtaEstado() {
        return ctaEstado;
    }

    public void setCtaEstado(String ctaEstado) {
        this.ctaEstado = ctaEstado;
    }

    public Long getCtaNumero() {
        return ctaNumero;
    }

    public void setCtaNumero(Long ctaNumero) {
        this.ctaNumero = ctaNumero;
    }

    public Long getCtaSaldoInicial() {
        return ctaSaldoInicial;
    }

    public void setCtaSaldoInicial(Long ctaSaldoInicial) {
        this.ctaSaldoInicial = ctaSaldoInicial;
    }

    public String getCtaTipoCuenta() {
        return ctaTipoCuenta;
    }

    public void setCtaTipoCuenta(String ctaTipoCuenta) {
        this.ctaTipoCuenta = ctaTipoCuenta;
    }

    public BigDecimal getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(BigDecimal totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public BigDecimal getTotalDebitos() {
        return totalDebitos;
    }

    public void setTotalDebitos(BigDecimal totalDebitos) {
        this.totalDebitos = totalDebitos;
    }

    public Long getMovSaldo() {
        return movSaldo;
    }

    public void setMovSaldo(Long movSaldo) {
        this.movSaldo = movSaldo;
    }
}
