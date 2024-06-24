package com.example.flowersapp.flowers;

import java.io.Serializable;

public class Flower implements Serializable {

    private Integer id;
    private String nombre;
    private String descripcion;
    private ImagenId imagenId;

    public Flower() {
    }

    public Flower(Integer id, String nombre, String descripcion, ImagenId imagenId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ImagenId getImagenId() {
        return imagenId;
    }

    public enum ImagenId {
        FLOR1,
        FLOR2,
        FLOR3,
        FLOR4,
        PLACEHOLDER
    }

}
