package com.example;

public abstract class Persona {
    protected String cedula;
    protected String nombre;
    protected String tipoSangre;
    public Persona(String cedula, String nombre, String tipoSangre) {
        this.cedula=cedula;
        this.nombre=nombre;
        this.tipoSangre=tipoSangre;
    }
    public String getCedula() {
        return(cedula);
    }
    public String getNombre() {
        return(nombre);
    }
    public String getTipoSangre() {
        return(tipoSangre);
    }
}
