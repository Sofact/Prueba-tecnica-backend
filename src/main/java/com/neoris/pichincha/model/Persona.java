package com.neoris.pichincha.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Long perId;


    @Column(name="per_nombre")
    private String perNombre;

    @Column(name="per_genero")
    private String perGenero;

    @Column(name="per_edad")
    private int perEdad;

    @Column(name="per_identificacion")
    private String perIdentificacion;

    @Column(name="per_direccion")
    private String perDireccion;

    @Column(name="per_telefono")
    private String perTelefono;



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

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public int getPerEdad() {
        return perEdad;
    }

    public void setPerEdad(int perEdad) {
        this.perEdad = perEdad;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }



}
