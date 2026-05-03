package com.example;

import com.example.ImplementacionFachada.Facade;
import com.example.ImplementacionFachada.IImpresion;
import com.example.ImplementacionFachada.ILector;
import com.example.ImplementacionFachada.Impresion;
import com.example.ImplementacionFachada.Lector;

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
        IImpresion impresion=new Impresion();
        ILector lector=new Lector();
        String opcion = "";
        while (!opcion.equals("-1")) {
            impresion.imprimir(facade.mostrarMenu());
            opcion = lector.leerLinea();
            switch (opcion) {
                case "-1":
                    break;
                case "1":
                    impresion.imprimir(facade.registrarDonante());
                    break;
                case "2":
                    impresion.imprimir(facade.cargarDonantesDesdeArchivo());
                    break;
                case "3":
                    impresion.imprimir(facade.buscarDonante());
                    break;
                case "4":
                    impresion.imprimir(facade.eliminarDonante());
                    break;
                case "5":
                    impresion.imprimir(facade.mostrarDonantes());
                    break;
                case "6":
                    impresion.imprimir(facade.registrarReceptor());
                    break;
                case "7":
                    impresion.imprimir(facade.cargarReceptoresDesdeArchivo());
                    break;
                case "8":
                    impresion.imprimir(facade.buscarReceptor());
                    break;
                case "9":
                    impresion.imprimir(facade.eliminarReceptor());
                    break;
                case "10":
                    impresion.imprimir(facade.mostrarReceptores());
                    break;
                case "11":
                    impresion.imprimir(facade.procesoMatch());
                    break;
                case "12":
                    impresion.imprimir(facade.mostrarTrasplantes());
                    break;
                default:
                    System.out.print("Opción no válida\r\n");

            }
        }
    }
}
