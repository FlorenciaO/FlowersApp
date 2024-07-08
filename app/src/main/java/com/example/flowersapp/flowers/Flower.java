package com.example.flowersapp.flowers;

import java.io.Serializable;

public class Flower implements Serializable {

    private Integer id;
    private String nombre;
    private String descripcion;
    private ImagenId imagenId;

    public Flower() {
    }

    public Flower(Flower flor) {
        this.id = flor.getId();
        this.nombre = flor.getNombre();
        this.descripcion = flor.getDescripcion();
        this.imagenId = flor.getImagenId();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenId(ImagenId imagenId) {
        this.imagenId = imagenId;
    }

    public enum ImagenId {
        FLOR1,
        FLOR2,
        FLOR3,
        FLOR4,
        PLACEHOLDER
    }

}
