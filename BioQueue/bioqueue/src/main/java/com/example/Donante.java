package com.example;

public class Donante extends Persona{


    private String organoDonado;

    public Donante(String cedula, String nombre, String organoDonado, String tipoSangre) {
        super(cedula,nombre, tipoSangre);
        this.organoDonado = organoDonado;
    }

    // Getters


    public String getOrganoDonado() {
        return organoDonado;
    }


    // Setters
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrgano_donado(String organo_donado) {
        this.organoDonado = organo_donado;
    }

   // public void setTipo_sangre(String tipo_sangre) {
     //   this.tipo_sangre = tipo_sangre;
    //}
}
