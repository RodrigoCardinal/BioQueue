package com.example;

import com.example.ImplementacionesTDA.ListaEnlazada;

public class RegistroTransplantes {

    ListaEnlazada<Transplante> listaTransplantes;

    public RegistroTransplantes() {
        listaTransplantes = new ListaEnlazada<>();
    }
    public void añadirTransplante(Donante donante, Receptor receptor) {
        this.listaTransplantes.agregar(new Transplante(donante, receptor));
    }
    public Transplante buscarTransplante(String CIdonante, String CIreceptor) {
        for(int i=0; i<listaTransplantes.tamaño();i++) {
            if((listaTransplantes.obtener(i).getDonante().getCedula().equals(CIdonante))&&(listaTransplantes.obtener(i).getReceptor().getCedula().equals(CIreceptor))) {
                return(listaTransplantes.obtener(i));
            }
        }
        return(null);
    }
    public String imprimirTransplantes()
    {
        StringBuilder toReturn= new StringBuilder();
        for(int i =0; i<listaTransplantes.tamaño(); i++) {
            toReturn.append("----------------------------------------------------------------------------\r\n");
            toReturn.append("CI receptor: "+listaTransplantes.obtener(i).getReceptor().getCedula()+".\r\n");
            toReturn.append("ÇI donante: "+listaTransplantes.obtener(i).getDonante().getCedula()+".\r\n");
            toReturn.append("Órgano donado: "+listaTransplantes.obtener(i).getDonante().getOrganoDonado()+".\r\n");
            toReturn.append("----------------------------------------------------------------------------\r\n");
        }
        return(toReturn.toString());
    }
}
