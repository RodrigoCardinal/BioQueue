package com.example;

public class Receptor 
{
    private String cedula;
    private String nombre;
    private String organo_necesitado;
    private String tipo_sangre;
    private int dias_en_espera;
    private int prioridad;
    
    public Receptor(String cedula, String nombre, String organo_necesitado, String tipo_sangre, int dias_en_espera, int prioridad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.organo_necesitado = organo_necesitado;
        this.tipo_sangre = tipo_sangre;
        this.dias_en_espera = dias_en_espera;
        this.prioridad = prioridad;
    }
    
    // Getters y setters
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getOrgano_necesitado() {
        return organo_necesitado;
    }
    public String getTipo_sangre() {
        return tipo_sangre;
    }
    public int getDias_en_espera() {
        return dias_en_espera;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) 
    {
        this.prioridad = prioridad;
    }
}
