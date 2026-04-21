package com.example;

public class SistemaBioQueue {
    private Lista_Donantes listaDonantes;
    private Lista_Receptores listaReceptores;
    private Lista_PosiblesTipodeSangre listaSangre;
    
    public SistemaBioQueue() {
        listaDonantes=new Lista_Donantes();
        listaReceptores=new Lista_Receptores();
        listaSangre=new Lista_PosiblesTipodeSangre();
    }

}
