package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Lista_Receptores listaReceptores = new Lista_Receptores("bioqueue\\src\\Resources\\Receptores.txt");
        listaReceptores.ordenarPorPrioridad();
        listaReceptores.MostrarReceptores(); 
        Lista_PosiblesTipodeSangre listaCompatibilidades = new Lista_PosiblesTipodeSangre();
        listaCompatibilidades.mostrarCompatibilidades();
        Lista_Donantes listaDonantes = new Lista_Donantes("bioqueue\\src\\Resources\\Donantes.txt");
        listaDonantes.MostrarDonantes();
    }
}
