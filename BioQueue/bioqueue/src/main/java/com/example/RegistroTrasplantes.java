package com.example;

import com.example.ImplementacionesTDA.ListaEnlazada;
import com.example.ImplementacionesTDA.TDANodo;

public class RegistroTrasplantes {

    ListaEnlazada<Trasplante> listaTrasplantes;

    public RegistroTrasplantes() {
        listaTrasplantes = new ListaEnlazada<>();
    }
    public void añadirTrasplante(Donante donante, Receptor receptor) {
        this.listaTrasplantes.agregar(new Trasplante(donante, receptor));
    }
    public Trasplante buscarTrasplante(String CIdonante, String CIreceptor) {
        TDANodo<Trasplante> aux=listaTrasplantes.getPrimero();
        while(aux!=null) {
            if((aux.getDato().getDonante().getCedula().equals(CIdonante))&&(aux.getDato().getReceptor().getCedula().equals(CIreceptor))) {
                return(aux.getDato());
            }
            aux=aux.getSiguiente();
        }
        return(null);
    }
    public String imprimirTrasplantes()
    {
        StringBuilder toReturn= new StringBuilder();
        toReturn.append("Se encontraron: "+String.valueOf(listaTrasplantes.tamaño())+" transplantes realizados.\r\n");
        TDANodo<Trasplante> aux=listaTrasplantes.getPrimero();
        while(aux!=null) {
            toReturn.append("----------------------------------------------------------------------------\r\n");
            toReturn.append("CI receptor: "+aux.getDato().getReceptor().getCedula()+".\r\n");
            toReturn.append("ÇI donante: "+aux.getDato().getDonante().getCedula()+".\r\n");
            toReturn.append("Órgano donado: "+aux.getDato().getDonante().getOrganoDonado()+".\r\n");
            toReturn.append("----------------------------------------------------------------------------\r\n");
            aux=aux.getSiguiente();
        }
        return(toReturn.toString());
    }
}
