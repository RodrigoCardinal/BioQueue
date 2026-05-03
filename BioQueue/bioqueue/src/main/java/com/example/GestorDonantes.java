package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

import com.example.ImplementacionesTDA.ListaEnlazada;
import com.example.ImplementacionesTDA.TDANodo;

public class GestorDonantes {

    private ListaEnlazada<Donante> listaDonantes;

    // public Lista_Donantes(String donantes) {
    //    this.listaDonantes = new ListaEnlazada<>(); //SE INICIALIZA LA LISTA ENLAZADA VACÍA CUANDO SE CREA UNA INSTANCIA DE LA CLASE Lista_Donantes.
    //    this.cargarDonantes(donantes); //SE LLAMA AL MÉTODO cargarDonantes PARA CARGAR LOS DATOS DE LOS DONANTES DESDE UN ARCHIVO CUYO NOMBRE SE PASA COMO ARGUMENTO AL CONSTRUCTOR.   
    //}
    public GestorDonantes() {
        this.listaDonantes = new ListaEnlazada<Donante>();
    }

    public void agregarDonante(String cedula, String nombre, String organoDonado, String tipoSangre) {
        listaDonantes.agregar(new Donante(cedula, nombre, organoDonado, tipoSangre));
    }

    public String cargarDonantes(String archivo) {
        listaDonantes = new ListaEnlazada<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                String cedula = datos[0].trim();
                String nombre = datos[1].trim();
                String organo_donado = datos[2].trim();
                String tipo_sangre = datos[3].trim();

                // Donante donante = new Donante(cedula, nombre, organo_donado, tipo_sangre);
                //listaDonantes.agregar(donante);
                this.agregarDonante(cedula, nombre, organo_donado, tipo_sangre);
            }
            return ("Se cargaron " + listaDonantes.tamaño() + " donantes.\r\n");
        } catch (Exception e) {
            return ("Error al leer donantes: " + e.getMessage() + ".\r\n");
        }
    }

    public String MostrarDonantes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Se encontraron: " + String.valueOf(listaDonantes.tamaño()) + " donantes. \r\n");
        TDANodo<Donante> donante = listaDonantes.getPrimero();
        while (donante != null) {
            resultado.append("Cédula: " + donante.getDato().getCedula() + ".\r\n");
            resultado.append("Nombre: " + donante.getDato().getNombre() + ".\r\n");
            resultado.append("Órgano Donado: " + donante.getDato().getOrganoDonado() + ".\r\n");
            resultado.append("Tipo de Sangre: " + donante.getDato().getTipoSangre() + ".\r\n");
            resultado.append("---------------------------\r\n");
            donante = donante.getSiguiente();
        }
        return (resultado.toString());
    }
// REVISAR MAÑANA===========================================================================

    public Donante buscarDonante(String cedula) {
        TDANodo<Donante> aux = listaDonantes.getPrimero();
        while (aux != null) {
            if (aux.getDato().getCedula().equals(cedula)) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public boolean eliminarDonante(String cedula) {
        TDANodo<Donante> aux = listaDonantes.getPrimero();
        while (aux != null) {
            if (aux.getDato().getCedula().equals(cedula)) {
                listaDonantes.eliminar(aux.getDato());
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

// Getter para acceder a la lista desde main (si es necesario)
    public ListaEnlazada<Donante> getListaDonantes() {
        return listaDonantes;
    }
}
