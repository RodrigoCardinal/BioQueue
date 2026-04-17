package com.example;

public class Donante {
    private String cedula;
    private String nombre;
    private String organo_donado;
    private String tipo_sangre;
    
    public Donante(String cedula, String nombre, String organo_donado, String tipo_sangre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.organo_donado = organo_donado;
        this.tipo_sangre = tipo_sangre;
    }
    
    // Getters
    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public String getOrgano_donado() { return organo_donado; }
    public String getTipo_sangre() { return tipo_sangre; }
    
    // Setters
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setOrgano_donado(String organo_donado) { this.organo_donado = organo_donado; }
    public void setTipo_sangre(String tipo_sangre) { this.tipo_sangre = tipo_sangre; }
}