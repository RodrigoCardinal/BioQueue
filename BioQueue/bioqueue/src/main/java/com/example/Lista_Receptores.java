package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import com.example.ImplementacionesTDA.ListaEnlazada;

public class Lista_Receptores {

    private ListaEnlazada<Receptor> listaReceptores; //ESTA ES LA LISTA ENLAZADA QUE VA A ALMACENAR LOS RECEPTORES, ES DECIR, LOS NODOS DE LA LISTA VAN A CONTENER OBJETOS DE TIPO RECEPTOR.    
    private ListaEnlazada<Receptor> lista_desempate;

    public Lista_Receptores(String receptores) 
{ 
    this.listaReceptores = new ListaEnlazada<>(); //SE INICIALIZA LA LISTA ENLAZADA VACÍA CUANDO SE CREA UNA INSTANCIA DE LA CLASE Lista_Receptores.
    this.archivoReceptores(receptores); //SE LLAMA AL MÉTODO archivoReceptores PARA CARGAR LOS DATOS DE LOS RECEPTORES DESDE UN ARCHIVO CUYO NOMBRE SE PASA COMO ARGUMENTO AL CONSTRUCTOR.   
   this.lista_desempate = new ListaEnlazada<>();    }
    
   public Lista_Receptores() {
        this.listaReceptores = new ListaEnlazada<Receptor>();
    }

    public void archivoReceptores(String receptores) {
        try (BufferedReader lector = new BufferedReader(new FileReader(receptores))) //SE UTILIZA UN BufferedReader PARA LEER EL ARCHIVO DE TEXTO QUE CONTIENE LOS DATOS DE LOS RECEPTORES. EL NOMBRE DEL ARCHIVO SE PASA COMO ARGUMENTO AL CONSTRUCTOR DE LA CLASE Lista_Receptores.
        {
            String linea;
            while ((linea = lector.readLine()) != null) //SE LEE EL ARCHIVO LÍNEA POR LÍNEA HASTA QUE SE LLEGUE AL FINAL DEL ARCHIVO (CUANDO readLine() DEVUELVE null).
            {
                String[] datos = linea.split(","); //CADA LÍNEA SE DIVIDE EN PARTES UTILIZANDO LA COMA COMO SEPARADOR, Y CADA PARTE SE ALMACENA EN UN ELEMENTO DEL ARREGLO datos.
                String cedula = datos[0].trim(); //SE ASIGNA CADA ELEMENTO DEL ARREGLO datos A UNA VARIABLE SEPARADA PARA MEJORAR LA LEGIBILIDAD DEL CÓDIGOS, PERO ESTO ES OPCIONAL Y SE PODRÍA HACER DIRECTAMENTE EN EL CONSTRUCTOR DE LA CLASE Receptor.
                String nombre = datos[1].trim();
                String organo_necesitado = datos[2].trim();
                String tipo_sangre = datos[3].trim();
                int dias_en_espera = Integer.parseInt(datos[4].trim()); //SE CONVIERTE EL QUINTO ELEMENTO DEL ARREGLO datos DE UN STRING A UN ENTERO UTILIZANDO Integer.parseInt(), YA QUE EL NÚMERO DE DÍAS EN ESPERA ES UN VALOR NUMÉRICO.
                int prioridad = Integer.parseInt(datos[5].trim());

                /* Dejo aca por si queremos convertir de numero a texto. Es de ka 
                implementacion vieja
                Convertir prioridad de texto a número (como String)
                String prioridadNumero;
                if (prioridadTexto.equals("Alta")) {
                    prioridadNumero = "1";
                } else if (prioridadTexto.equals("Media")) {
                    prioridadNumero = "2";
                } else if (prioridadTexto.equals("Baja")) {
                    prioridadNumero = "3";
                } else {
                    prioridadNumero = "0"; // valor por defecto si no se reconoce
                } */
                // Crear receptor con la prioridad convertida a número (como String)
                Receptor receptor = new Receptor(cedula, nombre, organo_necesitado,
                        tipo_sangre, dias_en_espera, prioridad);
                insertarOrdenado(receptor);
            }
        } catch (Exception e) {
            System.out.println("Error al leer receptores: " + e.getMessage());//tira error si no puede leer el archivo, mostrando un mensaje de error con la descripción del problema.
        }
    }

    private void insertarOrdenado(Receptor receptor) { //metodo que organiza segun prioridad 1 -> 2 -> 3
        if (listaReceptores.esVacia()) {
            listaReceptores.agregar(receptor);
            return;
        }

        int i = 0;
        while (i < listaReceptores.tamaño()) {
            Receptor actual = listaReceptores.obtener(i);

            if (receptor.getPrioridad() < actual.getPrioridad()
                    || (receptor.getPrioridad() == actual.getPrioridad()
                    && receptor.getDias_en_espera() > actual.getDias_en_espera())) {
                break;
            }
            i++;
        }
        listaReceptores.insertar(i, receptor);
    }


    public void MostrarReceptores() //ESTE MÉTODO SE UTILIZA PARA MOSTRAR LOS DATOS DE LOS RECEPTORES ALMACENADOS EN LA LISTA ENLAZADA listaReceptores. RECORRE LA LISTA Y IMPRIME LOS ATRIBUTOS DE CADA RECEPTOR.
    {
        for (int i = 0; i < listaReceptores.tamaño(); i++) //SE UTILIZA UN BUCLE FOR PARA RECORRER LA LISTA ENLAZADA DESDE EL PRIMER ELEMENTO HASTA EL ÚLTIMO, UTILIZANDO EL MÉTODO tamaño() PARA OBTENER EL NÚMERO DE ELEMENTOS EN LA LISTA.
        {
            Receptor receptor = listaReceptores.obtener(i); //SE OBTIENE CADA RECEPTOR DE LA LISTA UTILIZANDO EL MÉTODO obtener() DE LA CLASE ListaEnlazada, PASANDO EL ÍNDICE i COMO ARGUMENTO.
            System.out.println("Cédula: " + receptor.getCedula()); //SE IMPRIMEN LOS ATRIBUTOS DE CADA RECEPTOR UTILIZANDO LOS MÉTODOS GETTERS DEFINIDOS EN LA CLASE Receptor.
            System.out.println("Nombre: " + receptor.getNombre());
            System.out.println("Órgano Necesitado: " + receptor.getOrgano_necesitado());
            System.out.println("Tipo de Sangre: " + receptor.getTipo_sangre());
            System.out.println("Días en Espera: " + receptor.getDias_en_espera());
            System.out.println("Prioridad: " + receptor.getPrioridad());
            System.out.println("---------------------------");
        }
    }

    public void filtrarYDesempatar( String organoNecesitado, String tipoSangreDonante) 
    {
        
        System.out.println("\nBUSCAR RECEPTORES COMPATIBLES");
        System.out.println("Organo: " + organoNecesitado + " | Sangre donante: " + tipoSangreDonante);
        System.out.println("----------------------------------------");
        Lista_PosiblesTipodeSangre compatibilidad = new Lista_PosiblesTipodeSangre();
        ListaEnlazada<Receptor> receptoresCompatibles = new ListaEnlazada<>();
        
        for (int i = 0; i < listaReceptores.tamaño(); i++) 
            {
            Receptor receptor = listaReceptores.obtener(i);
            
            if (receptor.getOrgano_necesitado().equalsIgnoreCase(organoNecesitado)) 
                {
                if (compatibilidad.esCompatible(receptor.getTipo_sangre(), tipoSangreDonante)) 
                    {
                    System.out.println("COMPATIBLE: " + receptor.getNombre());
                    receptoresCompatibles.agregar(receptor);
                } 
                else 
                {
                    System.out.println("INCOMPATIBLE (sangre no compatible): " + receptor.getNombre());
                }
            } 
            else 
            {
                System.out.println("INCOMPATIBLE (organo diferente): " + receptor.getNombre());
            }
        }
               
        System.out.println("\nCompatibles encontrados: " + receptoresCompatibles.tamaño());
        
        if (receptoresCompatibles.tamaño() > 1) 
        {
            this.lista_desempate = new ListaEnlazada<>();
            
            for (int i = 0; i < receptoresCompatibles.tamaño(); i++) {
                this.lista_desempate.agregar(receptoresCompatibles.obtener(i));
            }
            
            desempateRandom();
            
        } 
        else if (receptoresCompatibles.tamaño() == 1) 
            {
            Receptor seleccionado = receptoresCompatibles.obtener(0);
            System.out.println("\nReceptor seleccionado: " + seleccionado.getNombre());
        } 
        else 
        {
            System.out.println("\nNo hay receptores compatibles.");
        }
    }
    
    public void desempateRandom() {
        int totalEmpatados = lista_desempate.tamaño();
        
        if (totalEmpatados == 0) {
            System.out.println("No hay receptores en la lista de desempate.");
            return;
        }
        
        Random random = new Random();
        int indiceSeleccionado = random.nextInt(totalEmpatados);
        Receptor receptorSeleccionado = lista_desempate.obtener(indiceSeleccionado);
        
        System.out.println("\nDESEMPATE POR RANDOM:");
        System.out.println("   Lista de empatados: " + totalEmpatados + " receptores");
        System.out.println("   Indice seleccionado: " + indiceSeleccionado);
        System.out.println("   Receptor seleccionado: " + receptorSeleccionado.getNombre());
    }
}