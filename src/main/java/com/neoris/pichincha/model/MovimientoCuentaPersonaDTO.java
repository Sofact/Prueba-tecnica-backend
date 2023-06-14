package com.neoris.pichincha.model;

import java.util.Date;

public class MovimientoCuentaPersonaDTO {


    private Long movId;

    private Date movfecha;

    private String movTipo;

    private Long movValor;

    private Long movSaldo;

    private String movEstado;

    private long ctaId;
    private String ctaTipoCuenta;
    private Long ctaNumero;

    private Long ctaSaldoInicial;

    private Long perId;
    private String perNombre;

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

    public long getCtaId() {
        return ctaId;
    }

    public void setCtaId(long ctaId) {
        this.ctaId = ctaId;
    }

    public String getCtaTipoCuenta() {
        return ctaTipoCuenta;
    }

    public void setCtaTipoCuenta(String ctaTipoCuenta) {
        this.ctaTipoCuenta = ctaTipoCuenta;
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

    public String getMovEstado() {
        return movEstado;
    }

    public void setMovEstado(String movEstado) {
        this.movEstado = movEstado;
    }
}
