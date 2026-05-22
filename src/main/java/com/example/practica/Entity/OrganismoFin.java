package com.example.practica.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "organismo_fin")
public class OrganismoFin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gestion;

    @Column(name = "codigo_organismo")
    private int codigoOrganismo;

    private String descripcion;

    private String sigla;

    public OrganismoFin() {
    }

    public OrganismoFin(Long id, int gestion, int codigoOrganismo, String descripcion, String sigla) {
        this.id = id;
        this.gestion = gestion;
        this.codigoOrganismo = codigoOrganismo;
        this.descripcion = descripcion;
        this.sigla = sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGestion() {
        return gestion;
    }

    public void setGestion(int gestion) {
        this.gestion = gestion;
    }

    public int getCodigoOrganismo() {
        return codigoOrganismo;
    }

    public void setCodigoOrganismo(int codigoOrganismo) {
        this.codigoOrganismo = codigoOrganismo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}