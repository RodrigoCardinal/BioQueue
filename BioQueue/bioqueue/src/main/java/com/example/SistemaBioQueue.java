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
/*
 private Lista_Donantes listaDonantes;
    private Lista_Receptores listaReceptores;
    private Lista_PosiblesTipodeSangre tablaSangre;
    private Cola<Donante> organosDisponibles;  
    private RegistroTransplantes registro;

      public SistemaBioQueue() {
        this.listaDonantes = new Lista_Donantes();
        this.listaReceptores = new Lista_Receptores();
        this.tablaSangre = new Lista_PosiblesTipodeSangre();
        this.organosDisponibles = new Cola<>();
        this.registro = new RegistroTransplantes();
        }
     public void ingresarDonante(String cedula, String nomrbe, String organo, String tipoSangre)
     {
        Donante nuevo = new Donante (cedula, nombre, organo, tipoSangre);
        listaDonantes.agregarDonante (cedula, nombre, organo, tipoSangre);
        organoDisponibles.encolar(nuevo);
        System.out.println("Donante" + nombre + " registrado. " + "Organos en espeerra: " + organosDisponibles.tamaño());
     }
    public void procesarOrgano(){
        if (organosDisponible.esVacia()){
        System.out.println("No hay organos disponibles para procesar. ");
        }
        return;
    }
    //Salida del Primer Organo
    Donante donante = organosDisponibles.descolar();
    System.out.println("\nProcesando órgano: " + donante.getOrgano_donado() + " del donante " + donante.getNombre() + " " + donante.getCedula())
 */
}