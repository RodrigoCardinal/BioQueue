package com.example;

import java.util.Random;

import com.example.ImplementacionesTDA.ListaEnlazada;
import com.example.ImplementacionesTDA.TDANodo;

public class SistemaBioQueue {

    private GestorReceptores gestorReceptores;
    private GestorDonantes gestorDonantes;
    private RegistroTrasplantes registroTrasplantes;

    public SistemaBioQueue() {
        gestorReceptores = new GestorReceptores();
        gestorDonantes = new GestorDonantes();
        registroTrasplantes = new RegistroTrasplantes();
    }

    public GestorReceptores getGestorReceptores() {
        return (gestorReceptores);
    }

    public GestorDonantes getGestorDonantes() {
        return gestorDonantes;
    }

    public RegistroTrasplantes getRegistroTrasplantes() {
        return registroTrasplantes;
    }
    
    public void desempateRandom(ListaEnlazada<Receptor> listaDesempate) {
        int totalEmpatados = listaDesempate.tamaño();

        if (totalEmpatados == 0) {
            System.out.println("No hay receptores en la lista de desempate.");
            return;
        }

        Random random = new Random();
        int indiceSeleccionado = random.nextInt(totalEmpatados);
        Receptor receptorSeleccionado = listaDesempate.obtener(indiceSeleccionado);

        System.out.println("\nDESEMPATE POR RANDOM:");
        System.out.println("   Lista de empatados: " + totalEmpatados + " receptores");
        System.out.println("   Indice seleccionado: " + indiceSeleccionado);
        System.out.println("   Receptor seleccionado: " + receptorSeleccionado.getNombre());
    }

    public String procesarDonante(Donante donante, RegistroTrasplantes registro) {
        String organo = donante.getOrganoDonado();
        String sangreDonante = donante.getTipoSangre();
        AnalisisDeSangre compatibilidad = new AnalisisDeSangre();

        // 1. Filtrar receptores compatibles (órgano y sangre)
        ListaEnlazada<Receptor> compatibles = new ListaEnlazada<>();
        TDANodo<Receptor> aux = gestorReceptores.getListaReceptores().getPrimero();
        while (aux != null) {
            if (aux.getDato().getOrganoNecesitado().equalsIgnoreCase(organo)
                    && compatibilidad.esCompatible(aux.getDato().getTipoSangre(), sangreDonante)) {
                compatibles.agregar(aux.getDato());
            }
            aux = aux.getSiguiente();
        }

        if (compatibles.tamaño() == 0) {
            return ("No hay receptores compatibles para " + donante.getNombre() + ".\r\n");
        }

        // 2. Seleccionar el mejor según prioridad (y desempate aleatorio)
        Receptor seleccionado = seleccionarMejorReceptor(compatibles);

        // 3. Eliminar receptor de la lista de espera, y elimina donante de la lista de donantes
        gestorReceptores.eliminarReceptor(seleccionado.getCedula());
        // 4. Registrar trasplante
        registro.añadirTrasplante(donante, seleccionado);

        return ("Trasplante realizado: " + donante.getNombre()
                + " (" + donante.getOrganoDonado() + ", " + donante.getTipoSangre() + ")"
                + " -> " + seleccionado.getNombre()
                + " (prioridad " + seleccionado.getPrioridad() + ").\r\n");
    }

    private Receptor seleccionarMejorReceptor(ListaEnlazada<Receptor> compatibles) {
        // Encontrar la prioridad más baja (mayor urgencia)
        int mejorPrioridad = Integer.MAX_VALUE;
        TDANodo<Receptor> aux = compatibles.getPrimero();
        while (aux != null) {
            int p = aux.getDato().getPrioridad();
            if (p < mejorPrioridad) {
                mejorPrioridad = p;
            }
            aux = aux.getSiguiente();
        }

        // Recolectar todos los que tienen esa prioridad
        ListaEnlazada<Receptor> empatados = new ListaEnlazada<>();
        TDANodo<Receptor> aux1=compatibles.getPrimero();
        while(aux1!=null) {
            if (aux1.getDato().getPrioridad() == mejorPrioridad) {
                empatados.agregar(aux1.getDato());
            }
            aux1=aux1.getSiguiente();
        }

        // Si hay más de uno, elegir aleatoriamente
        if (empatados.tamaño() == 1) {
            return empatados.obtener(0);
        }else {
        java.util.Random rand = new java.util.Random();
        return empatados.obtener(rand.nextInt(empatados.tamaño()));}
    }

    public String procesarListaEnteraDonantes() {
        StringBuilder resultado = new StringBuilder();
        TDANodo<Donante> nodo=gestorDonantes.getListaDonantes().getPrimero();
        while(nodo!=null) {
            Donante d =nodo.getDato();
            resultado.append(procesarDonante(d, registroTrasplantes));
            nodo=nodo.getSiguiente();
        }
        TDANodo<Trasplante> aux=registroTrasplantes.getListaTrasplantes().getPrimero();
        while(aux!=null) {
            gestorDonantes.getListaDonantes().eliminar(aux.getDato().getDonante());
            //gestorReceptores.getListaReceptores().eliminar(aux.getDato().getReceptor());
            aux=aux.getSiguiente();
        }
        return(resultado.toString());
    }
}
