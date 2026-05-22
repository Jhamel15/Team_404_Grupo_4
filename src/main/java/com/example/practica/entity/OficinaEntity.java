package com.example.practica.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "oficina")
public class OficinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String entidad;
    private String unidad;
    private String codofic;
    private String nomofic;
    private String observ;

    private LocalDateTime feult;

    private String usuar;
    private String api_estado;

    public OficinaEntity() {
    }

    public OficinaEntity(
            Integer id,
            String entidad,
            String unidad,
            String codofic,
            String nomofic,
            String observ,
            LocalDateTime feult,
            String usuar,
            String api_estado) {

        this.id = id;
        this.entidad = entidad;
        this.unidad = unidad;
        this.codofic = codofic;
        this.nomofic = nomofic;
        this.observ = observ;
        this.feult = feult;
        this.usuar = usuar;
        this.api_estado = api_estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCodofic() {
        return codofic;
    }

    public void setCodofic(String codofic) {
        this.codofic = codofic;
    }

    public String getNomofic() {
        return nomofic;
    }

    public void setNomofic(String nomofic) {
        this.nomofic = nomofic;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public LocalDateTime getFeult() {
        return feult;
    }

    public void setFeult(LocalDateTime feult) {
        this.feult = feult;
    }

    public String getUsuar() {
        return usuar;
    }

    public void setUsuar(String usuar) {
        this.usuar = usuar;
    }

    public String getApi_estado() {
        return api_estado;
    }

    public void setApi_estado(String api_estado) {
        this.api_estado = api_estado;
    }
}