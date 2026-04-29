package com.example;

public class Receptor extends Persona 
{

    private String organoNecesitado;
    private int diasEnEspera;
    private int prioridad;
    public Receptor(String cedula, String nombre, String organoNecesitado, String tipoSangre, int diasEnEspera, int prioridad) {
        super(cedula, nombre, tipoSangre);
        this.organoNecesitado=organoNecesitado;
        this.diasEnEspera=diasEnEspera;
        this.prioridad=prioridad;
    }
    
    // Getters y setters

    public String getOrganoNecesitado() {
        return organoNecesitado;
    }

    public int getDias_en_espera() {
        return diasEnEspera;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) 
    {
        this.prioridad = prioridad;
    }
}
