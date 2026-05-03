package com.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        /* 
        // Cargar receptores
        SistemaBioQueue sistemaBioQueue=new SistemaBioQueue();
        GestorReceptores listaReceptores = sistemaBioQueue.getGestorReceptores();
        listaReceptores.archivoReceptores("BioQueue\\bioqueue\\src\\Resources\\Receptores.csv");
        System.out.println("=== RECEPTORES INICIALES ===");
        listaReceptores.MostrarReceptores();

        // Cargar donantes
        GestorDonantes listaDonantes = sistemaBioQueue.getGestorDonantes();
        listaDonantes.cargarDonantes("BioQueue\\bioqueue\\src\\Resources\\Donantes.csv");
        System.out.println("\n=== DONANTES CARGADOS ===");
        listaDonantes.MostrarDonantes();

        // Registro de trasplantes
        RegistroTransplantes registro = new RegistroTransplantes();

        // Procesar cada donante automáticamente (asignar a receptor compatible)
        System.out.println("\n=== PROCESANDO DONANTES ===");
        for (int i = 0; i < listaDonantes.getListaDonantes().tamaño(); i++) {
            Donante d = listaDonantes.getListaDonantes().obtener(i);
            sistemaBioQueue.procesarDonante(d, registro);
        }

        // Mostrar resultados finales
        System.out.println("\n=== TRASPLANTES REGISTRADOS ===");
        System.out.println(registro.imprimirTransplantes());

        System.out.println("\n=== RECEPTORES EN ESPERA (NO ASIGNADOS) ===");
        listaReceptores.MostrarReceptores();



    1. Registrar receptor
    2. Registrar donante
    3. Buscar receptor
    4. Buscar donante
    5. Eliminar receptor
    6. Eliminar donante
    7. Listar receptores
    8. Listar donantes
    9. Listar órganos disponibles
    10. Ver historial de transplantes
    -1. Salir

    opcion ← leer entero

    SEGÚN opcion:
      1  → REGISTRAR_RECEPTOR()
      2  → REGISTRAR_DONANTE()
      3  → Leer cedula; BUSCAR_RECEPTOR(cedula)
      4  → Leer cedula; BUSCAR_DONANTE(cedula)
      5  → Leer cedula; ELIMINAR_RECEPTOR(cedula)
      6  → Leer cedula; ELIMINAR_DONANTE(cedula)
      7  → LISTAR_RECEPTORES()
      8  → LISTAR_DONANTES()
      9  → LISTAR_ORGANOS_DISPONIBLES()
      10 → mostrar historialTransplantes
      11 → SALIR

         */
        Facade facade = Facade.Instancia();
        String opcion = "";
        while (!opcion.equals("-1")) {
            facade.mostrarMenu();
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
            switch (opcion) {
                case "-1":
                    break;
                case "1":
                    Facade.Instancia().registrarDonante();
                    break;
                case "2":
                    Facade.Instancia().cargarDonantesDesdeArchivo();
                    break;
                case "3":
                    Facade.Instancia().buscarDonante();
                    break;
                case "4":
                    Facade.Instancia().eliminarDonante();
                    break;
                case "5":
                    Facade.Instancia().mostrarDonantes();
                    break;
                case "6":
                    Facade.Instancia().registrarReceptor();
                    break;
                case "7":
                    Facade.Instancia().cargarReceptoresDesdeArchivo();
                    break;
                case "8":
                    Facade.Instancia().buscarReceptor();
                    break;
                case "9":
                    Facade.Instancia().eliminarReceptor();
                    break;
                case "10":
                    Facade.Instancia().mostrarReceptores();
                    break;
                case "11":
                    Facade.Instancia().procesoMatch();
                    break;
                case "12":
                    Facade.Instancia().mostrarTrasplantes();
                    break;
                default:
                    System.out.print("Opción no válida\r\n");

            }
        }
    }
}
