package com.neoris.pichincha.model;

import jakarta.persistence.*;
import com.neoris.pichincha.model.Persona;

@Entity

@Table(name="cliente", schema="pc")
public class Cliente  extends Persona{

    private static final String SQ_CLIENTE = "seq_cliente";



    @Column(name="cli_contrasena")
    private String cliContrasena;

    @Column(name="cli_estado")
    private String cliEstado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_id")
    private Persona persona;



    public String getCliContrasena() {
        return cliContrasena;
    }

    public void setCliContrasena(String cliContrasena) {
        this.cliContrasena = cliContrasena;
    }

    public String getCliEstado() {
        return cliEstado;
    }

    public void setCliEstado(String cliEstado) {
        this.cliEstado = cliEstado;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}


