package com.example;

import java.util.Scanner;

public class Facade {

    private static Facade instancia;
    private SistemaBioQueue sistema;
    private Scanner sc = new Scanner(System.in);


    private Facade() {
        this.sistema = new SistemaBioQueue();
    }

    public static Facade Instancia() {
        if (instancia == null) {
            instancia = new Facade();
        }
        return (instancia);
    }

    public void mostrarMenu() {
        StringBuilder result = new StringBuilder();

        result.append("Ingrese -1 para salir.\r\n");
        result.append("Ingrese 1 para registrar un donante.\r\n"); //
        result.append("Ingrese 2 para cargar donantes desde un archivo.\r\n"); //
        result.append("Ingrese 3 para buscar un donante.\r\n"); //
        result.append("Ingrese 4 para eliminar un donante.\r\n"); //
        result.append("Ingrese 5 para mostrar donantes en la lista.\r\n"); //
        result.append("Ingrese 6 para registrar un receptor.\r\n");
        result.append("Ingrese 7 para cargar receptores desde un archivo.\r\n"); //
        result.append("Ingrese 8 para buscar un receptor.\r\n");
        result.append("Ingrese 9 para eliminar un receptor.\r\n");
        result.append("Ingrese 10 para mostrar receptores en la lista.\r\n"); //
        result.append("Ingrese 11 para hacer el proceso de asignación receptor-órgano.\r\n"); //
        result.append("Ingrese 12 para ver el historial de trasplantes. \r\n"); //
        System.out.print(result.toString());
    }

    public void cargarDonantesDesdeArchivo() {
        System.out.println("Ingresar la ruta del archivo");
        String archivo = sc.nextLine();
        sistema.getGestorDonantes().cargarDonantes(archivo);
    }

    public void mostrarDonantes() {
        sistema.getGestorDonantes().MostrarDonantes();
    }
    public void registrarDonante() {
        System.out.println("Ingresar en el siguiente órden: cedula,nombre,organoDonado,tipoSangre");
        String linea = sc.nextLine();
        String[] parametros=linea.split(",");
        try {
            sistema.getGestorDonantes().agregarDonante(parametros[0], parametros[1], parametros[2], parametros[3]);
            System.out.println("Donante agregado correctamente\r\n");
        } catch (Exception e) {
            System.err.println("Hubo un error con el ingreso de los parámetros.\r\n");
        }
    }
    public void buscarDonante() {
        System.out.println("Ingresar la cédula del donante a buscar.");
        String linea = sc.nextLine();
        sistema.getGestorDonantes().buscarDonante(linea);
    }
        public void eliminarDonante() {
        System.out.println("Ingresar la cédula del donante a eliminar.");
        String linea = sc.nextLine();
        sistema.getGestorDonantes().eliminarDonante(linea);
    }

    public void mostrarReceptores() {
        sistema.getGestorReceptores().MostrarReceptores();
    }

    public void cargarReceptoresDesdeArchivo() {
        System.out.println("Ingresar la ruta del archivo");
        String archivo = sc.nextLine();
        sistema.getGestorReceptores().archivoReceptores(archivo);
    }


    public void registrarReceptor() {
        System.out.println("Ingresar en el siguiente órden: cedula,nombre,organoNecesitado,tipoSangre,diasEnEspera,prioridad");
        String linea = sc.nextLine();
        String[] parametros=linea.split(",");
        try {
            sistema.getGestorReceptores().agregarReceptor(parametros[0], parametros[1], parametros[2], parametros[3], Integer.valueOf(parametros[4]),Integer.valueOf(parametros[5]));
        } catch (Exception e) {
            System.err.println("Hubo un error con el ingreso de los parámetros.");
        }
    }
    public void buscarReceptor() {
        System.out.println("Ingresar la cédula del receptor a buscar.");
        String linea = sc.nextLine();
        sistema.getGestorReceptores().buscarReceptor(linea);
    }
        public void eliminarReceptor() {
        System.out.println("Ingresar la cédula del receptor a eliminar.");
        String linea = sc.nextLine();
        sistema.getGestorReceptores().eliminarReceptor(linea);
    }

    public void procesoMatch() {
        for (int i = 0; i < sistema.getGestorDonantes().getListaDonantes().tamaño(); i++) {
            Donante d = sistema.getGestorDonantes().getListaDonantes().obtener(i);
            sistema.procesarDonante(d, sistema.getRegistroTrasplantes());
        }
    }

    public void mostrarTrasplantes() {
        System.out.print(sistema.getRegistroTrasplantes().imprimirTrasplantes());
    }
}
