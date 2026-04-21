package com.example;
import java.util.Random;
import com.example.ImplementacionesTDA.ListaEnlazada;

public class SistemaBioQueue {
/* 
    private ListaEnlazada<Receptor> lista_desempate;
    private ListaEnlazada<Receptor> lista_receptores;

    public SistemaBioQueue() {
        this.lista_desempate = new ListaEnlazada<>();
        this.lista_receptores = new ListaEnlazada<>();
    }



    public void desempateRandom() {
        int totalEmpatados = lista_desempate.tamaño();

        if (totalEmpatados == 0) {
            System.out.println("No hay receptores en la lista de desempate.");
            return;
        }

        Random random = new Random();
        int indiceSeleccionado = random.nextInt(0,totalEmpatados);  //Sabemos que el random empieza desde cero pero decidimos ponerlo solo para enderderlo mejor
        Receptor receptorSeleccionado = lista_desempate.obtener(indiceSeleccionado);

        System.out.println("DESEMPATE POR RANDOM:");
        System.out.println("   Lista de empatados: " + totalEmpatados + " receptores");
        System.out.println("   Índice seleccionado: " + indiceSeleccionado);
        System.out.println("   Receptor seleccionado: " + receptorSeleccionado.getNombre() + " (Cédula: " + receptorSeleccionado.getCedula() + ", Órgano necesario: " + receptorSeleccionado.getOrgano_necesitado() + ", Prioridad: " + receptorSeleccionado.getPrioridad() + ")");
    }
        */
}