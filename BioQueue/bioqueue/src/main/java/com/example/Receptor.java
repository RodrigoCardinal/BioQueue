package com.example;

public class Receptor extends Persona 
{

    private String organoNecesitado;
    private int diasEnEspera;
    private int prioridad;
    
    public Receptor(String cedula, String nombre, String organoNecesitado, String tipoSangre, int diasEnEspera, int prioridad) {
        super(cedula, nombre, tipoSangre);
        this.organoNecesitado=organoNecesitado;
        setDiasEnEspera(diasEnEspera);
        setPrioridad(prioridad);
    }
    
    public String getOrganoNecesitado() {
        return organoNecesitado;
    }

    public int getDiasEnEspera() {
        return diasEnEspera;
    }
    
    public void setDiasEnEspera(int diasEnEspera) {
        if (diasEnEspera < 0) {
            throw new IllegalArgumentException("Los días en espera no pueden ser negativos.");
        }
        this.diasEnEspera = diasEnEspera;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    public void setPrioridad(int prioridad) 
    {
        if (prioridad < 1 || prioridad > 3) {
            throw new IllegalArgumentException("La prioridad debe estar entre 1 y 3, ingrese una priodidad valida");
        }
        this.prioridad = prioridad;
    }
}
