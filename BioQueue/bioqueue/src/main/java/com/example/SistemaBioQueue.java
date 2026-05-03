package com.example;

import java.util.Random;

import com.example.ImplementacionesTDA.ListaEnlazada;

public class SistemaBioQueue {

    private GestorReceptores gestorReceptores;
    private GestorDonantes gestorDonantes;
    private RegistroTrasplantes registroTrasplantes;

    public SistemaBioQueue() {
        gestorReceptores = new GestorReceptores();
        gestorDonantes=new GestorDonantes();
        registroTrasplantes=new RegistroTrasplantes();
    }
    public GestorReceptores getGestorReceptores() {
        return(gestorReceptores);
    }

    public GestorDonantes getGestorDonantes() {
        return gestorDonantes;
    }

    public RegistroTrasplantes getRegistroTrasplantes() {
        return registroTrasplantes;
    }
    
    public void filtrarYDesempatar(String organoNecesitado, String tipoSangreDonante) {

        System.out.println("\nBUSCAR RECEPTORES COMPATIBLES");
        System.out.println("Organo: " + organoNecesitado + " | Sangre donante: " + tipoSangreDonante);
        System.out.println("----------------------------------------");
        AnalisisDeSangre compatibilidad = new AnalisisDeSangre();
        ListaEnlazada<Receptor> receptoresCompatibles = new ListaEnlazada<>();

        for (int i = 0; i < gestorReceptores.getListaReceptores().tamaño(); i++) {
            Receptor receptor = gestorReceptores.getListaReceptores().obtener(i);

            if (receptor.getOrganoNecesitado().equalsIgnoreCase(organoNecesitado)) {
                if (compatibilidad.esCompatible(receptor.getTipoSangre(), tipoSangreDonante)) {
                    System.out.println("COMPATIBLE: " + receptor.getNombre());
                    receptoresCompatibles.agregar(receptor);
                } else {
                    System.out.println("INCOMPATIBLE (sangre no compatible): " + receptor.getNombre());
                }
            } else {
                System.out.println("INCOMPATIBLE (organo diferente): " + receptor.getNombre());
            }
        }

        System.out.println("\nCompatibles encontrados: " + receptoresCompatibles.tamaño());

        if (receptoresCompatibles.tamaño() > 1) {
            ListaEnlazada<Receptor> listaDesempate = new ListaEnlazada<>();

            for (int i = 0; i < receptoresCompatibles.tamaño(); i++) {
                listaDesempate.agregar(receptoresCompatibles.obtener(i));
            }

            desempateRandom(listaDesempate);

        } else if (receptoresCompatibles.tamaño() == 1) {
            Receptor seleccionado = receptoresCompatibles.obtener(0);
            System.out.println("\nReceptor seleccionado: " + seleccionado.getNombre());
        } else {
            System.out.println("\nNo hay receptores compatibles.");
        }
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

    public void procesarDonante(Donante donante, RegistroTrasplantes registro) {
        String organo = donante.getOrganoDonado();
        String sangreDonante = donante.getTipoSangre();
        AnalisisDeSangre compatibilidad = new AnalisisDeSangre();

        // 1. Filtrar receptores compatibles (órgano y sangre)
        ListaEnlazada<Receptor> compatibles = new ListaEnlazada<>();
        for (int i = 0; i < gestorReceptores.getListaReceptores().tamaño(); i++) {
            Receptor r = gestorReceptores.getListaReceptores().obtener(i);
            if (r.getOrganoNecesitado().equalsIgnoreCase(organo)
                    && compatibilidad.esCompatible(r.getTipoSangre(), sangreDonante)) {
                compatibles.agregar(r);
            }
        }

        if (compatibles.tamaño() == 0) {
            System.out.println("No hay receptores compatibles para " + donante.getNombre());
            return;
        }

        // 2. Seleccionar el mejor según prioridad (y desempate aleatorio)
        Receptor seleccionado = seleccionarMejorReceptor(compatibles);

        // 3. Eliminar receptor de la lista de espera
        gestorReceptores.eliminarReceptor(seleccionado.getCedula());

        // 4. Registrar trasplante
        registro.añadirTrasplante(donante, seleccionado);

        System.out.println("Trasplante realizado: " + donante.getNombre()
                + " (" + donante.getOrganoDonado() + ", " + donante.getTipoSangre() + ")"
                + " -> " + seleccionado.getNombre()
                + " (prioridad " + seleccionado.getPrioridad() + ")");
    }

    private Receptor seleccionarMejorReceptor(ListaEnlazada<Receptor> compatibles) {
        // Encontrar la prioridad más baja (mayor urgencia)
        int mejorPrioridad = Integer.MAX_VALUE;
        for (int i = 0; i < compatibles.tamaño(); i++) {
            int p = compatibles.obtener(i).getPrioridad();
            if (p < mejorPrioridad) {
                mejorPrioridad = p;
            }
        }

        // Recolectar todos los que tienen esa prioridad
        ListaEnlazada<Receptor> empatados = new ListaEnlazada<>();
        for (int i = 0; i < compatibles.tamaño(); i++) {
            Receptor r = compatibles.obtener(i);
            if (r.getPrioridad() == mejorPrioridad) {
                empatados.agregar(r);
            }
        }

        // Si hay más de uno, elegir aleatoriamente
        if (empatados.tamaño() == 1) {
            return empatados.obtener(0);
        }
        java.util.Random rand = new java.util.Random();
        return empatados.obtener(rand.nextInt(empatados.tamaño()));
    }
    //REVISAR MAÑANA===============================================
    // Dentro de Lista_Receptores.java
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
