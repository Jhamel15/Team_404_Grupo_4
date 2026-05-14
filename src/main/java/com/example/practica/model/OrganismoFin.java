package com.example.practica.model;

public class OrganismoFin {

    private int gestion;
    private int codigoOrganismo;
    private String descripcion;
    private String sigla;

    public OrganismoFin() {
    }

    public OrganismoFin(int gestion, int codigoOrganismo, String descripcion, String sigla) {
        this.gestion = gestion;
        this.codigoOrganismo = codigoOrganismo;
        this.descripcion = descripcion;
        this.sigla = sigla;
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