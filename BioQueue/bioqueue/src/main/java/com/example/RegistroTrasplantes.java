package com.example;

import com.example.ImplementacionesTDA.ListaEnlazada;

public class RegistroTrasplantes {

    ListaEnlazada<Trasplante> listaTrasplantes;

    public RegistroTrasplantes() {
        listaTrasplantes = new ListaEnlazada<>();
    }
    public void añadirTrasplante(Donante donante, Receptor receptor) {
        this.listaTrasplantes.agregar(new Trasplante(donante, receptor));
    }
    public Trasplante buscarTrasplante(String CIdonante, String CIreceptor) {
        for(int i=0; i<listaTrasplantes.tamaño();i++) {
            if((listaTrasplantes.obtener(i).getDonante().getCedula().equals(CIdonante))&&(listaTrasplantes.obtener(i).getReceptor().getCedula().equals(CIreceptor))) {
                return(listaTrasplantes.obtener(i));
            }
        }
        return(null);
    }
    public String imprimirTrasplantes()
    {
        StringBuilder toReturn= new StringBuilder();
        toReturn.append("Se encontraron: "+String.valueOf(listaTrasplantes.tamaño())+" transplantes realizados.\r\n");
        for(int i =0; i<listaTrasplantes.tamaño(); i++) {
            toReturn.append("----------------------------------------------------------------------------\r\n");
            toReturn.append("CI receptor: "+listaTrasplantes.obtener(i).getReceptor().getCedula()+".\r\n");
            toReturn.append("ÇI donante: "+listaTrasplantes.obtener(i).getDonante().getCedula()+".\r\n");
            toReturn.append("Órgano donado: "+listaTrasplantes.obtener(i).getDonante().getOrganoDonado()+".\r\n");
            toReturn.append("----------------------------------------------------------------------------\r\n");
        }
        return(toReturn.toString());
    }
}
