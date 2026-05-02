package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

import com.example.ImplementacionesTDA.ListaEnlazada;

public class GestorDonantes {

    private ListaEnlazada<Donante> listaDonantes;

   // public Lista_Donantes(String donantes) {
    //    this.listaDonantes = new ListaEnlazada<>(); //SE INICIALIZA LA LISTA ENLAZADA VACÍA CUANDO SE CREA UNA INSTANCIA DE LA CLASE Lista_Donantes.
    //    this.cargarDonantes(donantes); //SE LLAMA AL MÉTODO cargarDonantes PARA CARGAR LOS DATOS DE LOS DONANTES DESDE UN ARCHIVO CUYO NOMBRE SE PASA COMO ARGUMENTO AL CONSTRUCTOR.   
    //}
    public GestorDonantes() {
        this.listaDonantes=new ListaEnlazada<Donante>();
    }
    public void agregarDonante(String cedula, String nombre, String organoDonado, String tipoSangre) {
        listaDonantes.agregar(new Donante(cedula, nombre, organoDonado, tipoSangre));
    }
    
    public void cargarDonantes(String archivo) {
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
            System.out.println("Se cargaron " + listaDonantes.tamaño() + " donantes.");
        } catch (Exception e) {
            System.out.println("Error al leer donantes: " + e.getMessage());
        }
    }

    public void MostrarDonantes() {
        for (int i = 0; i < listaDonantes.tamaño(); i++) {
            Donante donante = listaDonantes.obtener(i);
            System.out.println("Cédula: " + donante.getCedula());
            System.out.println("Nombre: " + donante.getNombre());
            System.out.println("Órgano Donado: " + donante.getOrganoDonado());
            System.out.println("Tipo de Sangre: " + donante.getTipoSangre());
            System.out.println("---------------------------");

        }
    }
// REVISAR MAÑANA===========================================================================

public Donante buscarDonante(String cedula) {
    for (int i = 0; i < listaDonantes.tamaño(); i++) {
        Donante d = listaDonantes.obtener(i);
        if (d.getCedula().equals(cedula)) return d;
    }
    return null;
}

public boolean eliminarDonante(String cedula) {
    for (int i = 0; i < listaDonantes.tamaño(); i++) {
        if (listaDonantes.obtener(i).getCedula().equals(cedula)) {
            listaDonantes.eliminar(i);
            return true;
        }
    }
    return false;
}

// Getter para acceder a la lista desde main (si es necesario)
public ListaEnlazada<Donante> getListaDonantes() {
    return listaDonantes;
}
}