package com.example;

import com.example.ImplementacionFachada.Facade;
import com.example.ImplementacionFachada.IImpresion;
import com.example.ImplementacionFachada.ILector;
import com.example.ImplementacionFachada.Impresion;
import com.example.ImplementacionFachada.Lector;

public class App {

    public static void main(String[] args) {
        
        IImpresion impresion=new Impresion();
        ILector lector=new Lector();
        Facade facade = new Facade(lector);
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
