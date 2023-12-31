package com.neoris.pichincha.model;

import jakarta.persistence.*;

@Entity
@Table(name="cuenta")
public class Cuenta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cta_id")
    private Long ctaId;

    @Column(name="cta_numero")
    private Long ctaNumero;

    @Column(name="cta_tipo_cuenta")
    private String ctaTipoCuenta;

    @Column(name="cta_saldo_inicial")
    private Long ctaSaldoInicial;

    @Column(name="cta_estado")
    private String ctaEstado;

    @Column(name="per_id")
    private Long perId;



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

    public String getCtaTipoCuenta() {
        return ctaTipoCuenta;
    }

    public void setCtaTipoCuenta(String ctaTipoCuenta) {
        this.ctaTipoCuenta = ctaTipoCuenta;
    }

    public Long getCtaSaldoInicial() {
        return ctaSaldoInicial;
    }

    public void setCtaSaldoInicial(Long ctaSaldoInicial) {
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
}
