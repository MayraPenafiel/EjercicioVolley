package com.example.apivolley.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animales {

    //Atributos

    private String nombre;
    private String nombreLatin;
    private String tipo;
    private String actividad;
    private int longitudMax; //Medida:pies
    private int longitudMin; //Medida:pies
    private int pesoMin; //Medida:libras
    private int pesoMax; //Medida:libras
    private int tiempoVida; //Medida:años
    private String habitat;
    private String dieta;
    private String rangoGeografico;
    private String imagen; //link
    private int id;

    //Metodos Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreLatin() {
        return nombreLatin;
    }

    public void setNombreLatin(String nombreLatin) {
        this.nombreLatin = nombreLatin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public int getLongitudMax() {
        return longitudMax;
    }

    public void setLongitudMax(int longitudMax) {
        this.longitudMax = longitudMax;
    }

    public int getLongitudMin() {
        return longitudMin;
    }

    public void setLongitudMin(int longitudMin) {
        this.longitudMin = longitudMin;
    }

    public int getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(int pesoMin) {
        this.pesoMin = pesoMin;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }

    public int getTiempoVida() {
        return tiempoVida;
    }

    public void setTiempoVida(int tiempoVida) {
        this.tiempoVida = tiempoVida;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getRangoGeografico() {
        return rangoGeografico;
    }

    public void setRangoGeografico(String rangoGeografico) {
        this.rangoGeografico = rangoGeografico;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
