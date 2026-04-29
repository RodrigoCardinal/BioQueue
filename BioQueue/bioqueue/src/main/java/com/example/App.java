package com.example;

public class App {
    public static void main(String[] args) {
        // Cargar receptores
        Lista_Receptores listaReceptores = new Lista_Receptores();
        listaReceptores.archivoReceptores("BioQueue/bioqueue/src/Resources/Receptores.txt");
        System.out.println("=== RECEPTORES INICIALES ===");
        listaReceptores.MostrarReceptores();

        // Cargar donantes
        Lista_Donantes listaDonantes = new Lista_Donantes();
        listaDonantes.cargarDonantes("BioQueue/bioqueue/src/Resources/Donantes.txt");
        System.out.println("\n=== DONANTES CARGADOS ===");
        listaDonantes.MostrarDonantes();

        // Registro de trasplantes
        RegistroTransplantes registro = new RegistroTransplantes();

        // Procesar cada donante automáticamente (asignar a receptor compatible)
        System.out.println("\n=== PROCESANDO DONANTES ===");
        for (int i = 0; i < listaDonantes.getListaDonantes().tamaño(); i++) {
            Donante d = listaDonantes.getListaDonantes().obtener(i);
            listaReceptores.procesarDonante(d, registro);
        }

        // Mostrar resultados finales
        System.out.println("\n=== TRASPLANTES REGISTRADOS ===");
        System.out.println(registro.imprimirTransplantes());

        System.out.println("\n=== RECEPTORES EN ESPERA (NO ASIGNADOS) ===");
        listaReceptores.MostrarReceptores();
    }
}