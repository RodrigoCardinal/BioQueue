package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Lista_Receptores listaReceptores = new Lista_Receptores("BioQueue\\bioqueue\\src\\Resources\\Receptores.txt");
        listaReceptores.MostrarReceptores();
        Lista_PosiblesTipodeSangre listaCompatibilidades = new Lista_PosiblesTipodeSangre();
        listaCompatibilidades.mostrarCompatibilidades();
        Lista_Donantes listaDonantes = new Lista_Donantes();
        listaDonantes.cargarDonantes("BioQueue\\bioqueue\\src\\Resources\\Donantes.txt");
        listaDonantes.MostrarDonantes();
    }
}
