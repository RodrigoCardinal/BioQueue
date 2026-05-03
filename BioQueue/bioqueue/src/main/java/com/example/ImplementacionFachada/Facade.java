package com.example.ImplementacionFachada;

import com.example.Donante;
import com.example.Receptor;
import com.example.SistemaBioQueue;

public class Facade {

    private static Facade instancia;
    private SistemaBioQueue sistema;
    private ILector lector;

    public Facade(ILector lector) {
        this.sistema = new SistemaBioQueue();
        this.lector = lector;
    }

    public String mostrarMenu() {
        StringBuilder result = new StringBuilder();

        result.append("Ingrese -1 para salir.\r\n");
        result.append("Ingrese 1 para registrar un donante (Ingresar los datos de la siguiente manera: cedula,nombre,organoDonado,tipoSangre).\r\n"); //
        result.append("Ingrese 2 para cargar donantes desde un archivo (Ingresar ruta del archivo).\r\n"); //
        result.append("Ingrese 3 para buscar un donante (Ingresar la cédula del donante a buscar).\r\n"); //
        result.append("Ingrese 4 para eliminar un donante (Ingresar la cédula del donante a eliminar).\r\n"); //
        result.append("Ingrese 5 para mostrar donantes en la lista.\r\n"); //
        result.append("Ingrese 6 para registrar un receptor (Ingresar los datos de la siguiente manera: cedula,nombre,organoNecesitado,tipoSangre,diasEnEspera,prioridad).\r\n");
        result.append("Ingrese 7 para cargar receptores desde un archivo (ingresar ruta del archivo).\r\n"); //
        result.append("Ingrese 8 para buscar un receptor (Ingresar la cédula del receptor a buscar).\r\n");
        result.append("Ingrese 9 para eliminar un receptor (Ingresar la cédula del receptor a eliminar).\r\n");
        result.append("Ingrese 10 para mostrar receptores en la lista.\r\n"); //
        result.append("Ingrese 11 para hacer el proceso de asignación receptor-órgano.\r\n"); //
        result.append("Ingrese 12 para ver el historial de trasplantes. \r\n"); //
        return (result.toString());
    }

    public String cargarDonantesDesdeArchivo() {
        String archivo = lector.leerLinea();
        return sistema.getGestorDonantes().cargarDonantes(archivo);
    }

    public String mostrarDonantes() {
        return sistema.getGestorDonantes().MostrarDonantes();
    }

    public String registrarDonante() {
        String linea = lector.leerLinea();
        String[] parametros = linea.split(",");
        try {
            sistema.getGestorDonantes().agregarDonante(parametros[0], parametros[1], parametros[2], parametros[3]);
            return ("Donante agregado correctamente\r\n");
        } catch (Exception e) {
            return ("Hubo un error al intentar ingresar al donante.\r\n");
        }
    }

    public String buscarDonante() {
        String linea = lector.leerLinea();
        Donante result = sistema.getGestorDonantes().buscarDonante(linea);
        if (result != null) {
            return ("Donante encontrado:\r\nCédula: " + result.getCedula() + "\r\nNombre: " + result.getNombre() + "\r\nÓrgano donado: " + result.getOrganoDonado() + "\r\nTipo de Sangre: " + result.getTipoSangre() + ". \r\n");
        } else {
            return ("Donante no encontrado. \r\n");
        }
    }

    public String eliminarDonante() {
        String linea = lector.leerLinea();
        boolean result = sistema.getGestorDonantes().eliminarDonante(linea);
        if (result) {
            return ("Donante eliminado correctamente. \r\n");
        } else {
            return ("Donante no encontrado. \r\n");
        }
    }

    public String mostrarReceptores() {
        return (sistema.getGestorReceptores().MostrarReceptores());
    }

    public String cargarReceptoresDesdeArchivo() {
        String archivo = lector.leerLinea();
        return (sistema.getGestorReceptores().archivoReceptores(archivo));
    }

    public String registrarReceptor() {
        String linea = lector.leerLinea();
        String[] parametros = linea.split(",");
        try {
            sistema.getGestorReceptores().agregarReceptor(parametros[0], parametros[1], parametros[2], parametros[3], Integer.valueOf(parametros[4]), Integer.valueOf(parametros[5]));
            return ("Receptor registrado correctamente. \r\n");
        } catch (Exception e) {
            return ("Hubo un error al ingresar al receptor. \r\n");
        }
    }

    public String buscarReceptor() {
        String linea = lector.leerLinea();
        Receptor result = sistema.getGestorReceptores().buscarReceptor(linea);
        if (result != null) {
            return ("Receptor encontrado:\r\nCédula: " + result.getCedula() + "\r\nNombre: " + result.getNombre() + "\r\nÓrgano Necesitado: " + result.getOrganoNecesitado() + "\r\nTipo de Sangre: " + result.getTipoSangre() + "\r\nDías en Espera: " + result.getDiasEnEspera() + "\r\nPrioridad: " + result.getPrioridad() + ". \r\n");
        } else {
            return ("Receptor no encontrado. \r\n");
        }
    }

    public String eliminarReceptor() {
        String linea = lector.leerLinea();
        boolean result = sistema.getGestorReceptores().eliminarReceptor(linea);
        if (result) {
            return ("Receptor eliminado correctamente. \r\n");
        } else {
            return ("Receptor no encontrado. \r\n");
        }
    }

    public String procesoMatch() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < sistema.getGestorDonantes().getListaDonantes().tamaño(); i++) {
            Donante d = sistema.getGestorDonantes().getListaDonantes().obtener(i);
            resultado.append(sistema.procesarDonante(d, sistema.getRegistroTrasplantes()));
        }
        return (resultado.toString());
    }

    public String mostrarTrasplantes() {
        return (sistema.getRegistroTrasplantes().imprimirTrasplantes());
    }
}
