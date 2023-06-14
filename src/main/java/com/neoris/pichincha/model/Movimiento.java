package com.neoris.pichincha.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="movimiento", schema="pc")
public class Movimiento {

    private static final String SQ_MOVIMIENTO = "seq_movimiento";
    @Id
    @GeneratedValue(generator=Movimiento.SQ_MOVIMIENTO, strategy= GenerationType.AUTO)
    @SequenceGenerator(schema="pc", name=Movimiento.SQ_MOVIMIENTO ,   sequenceName=Movimiento.SQ_MOVIMIENTO, initialValue=1, allocationSize=1)
    @Column(name="mov_id")
    private Long movId;

    @Column(name="mov_fecha")
    private Date movfecha;

    @Column(name="mov_tipo")
    private String movTipo;

    @Column(name="mov_valor")
    private Long movValor;

    @Column(name="mov_saldo")
    private Long movSaldo;

    @Column(name="cta_id")
    private Long ctaId;

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
}
