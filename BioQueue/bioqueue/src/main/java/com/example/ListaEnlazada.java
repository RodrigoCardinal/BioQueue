package com.example;//ACA ESTA EL "COMO" DE LA LISTA, OSEA, LA IMPLEMENTACIÓN DE LOS MÉTODOS DEFINIDOS EN LA INTERFAZ TDALista.

import java.util.Comparator;

public class ListaEnlazada<T> implements TDALista<T> //LA CLASE LISTAENLAZADA IMPLEMENTA LA INTERFAZ TDALista, LO QUE SIGNIFICA QUE DEBE PROPORCIONAR UNA IMPLEMENTACIÓN PARA TODOS LOS MÉTODOS DEFINIDOS EN LA INTERFAZ TDALista.
{
    protected TDANodo<T> primero; // el primer nodo de la lista, es decir, el nodo que se encuentra al inicio de la lista. Este nodo es el punto de entrada a la lista, y a través de él podemos acceder a todos los demás nodos de la lista.
    // constructor
    public ListaEnlazada() //CONSTRUCTOR DE LA CLASE LISTAENLAZADA, QUE SE ENCARGA DE INICIALIZAR LA LISTA.
    {
        this.primero = null;//INICIALIZA EL ATRIBUTO PRIMERO COMO NULL, LO QUE SIGNIFICA QUE LA LISTA ESTÁ VACÍA AL CREARLA.
    }
    
    // implementar métodos del TDALista
    @Override
    public boolean agregar(T Receptores) {
        TDANodo<T> nuevoNodo = new TDANodo<>(Receptores); //CREA UN NUEVO NODO CON EL RECEPTOR QUE SE QUIERE AGREGAR A LA LISTA.
        if (primero == null) {
            primero = nuevoNodo; //Si la lista está vacía, el nuevo nodo se convierte en el primer nodo de la lista.
        } else {
            TDANodo<T> actual = primero; //Si la lista no está vacía, se recorre la lista hasta llegar al último nodo (el nodo cuyo siguiente es null) y se establece el nuevo nodo como el siguiente del último nodo.
            while (actual.getSiguiente() != null) //Es aca donde se va recorriendo la lista ya creada hasta encontrar ese nodo cuyo siguienter sea nulo para que esa sentencia de while sea "FALSE" y se salga del while, y ahi se establece el nuevo nodo como el siguiente del último nodo encontrado.
            {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo); //Aca se asigna el nuevo nodo como el siguiente del último nodo encontrado, lo que significa que el nuevo nodo se agrega al final de la lista.
        }
        return true;
        //ESTO DEVOLVERIA TRUE SI EL LIBRO SE AGREGÓ CORRECTAMENTE A LA LISTA, LO QUE EN ESTE CASO SIEMPRE SERÁ ASÍ, YA QUE NO HAY CONDICIONES QUE IMPIDAN AGREGAR UN LIBRO A LA LISTA.
    }
    @Override
    public T obtener(int indice) 
    {
        TDANodo<T> actual = primero; //Se inicia una variante donde el primer nodo es igual al actual
        int contador = 0; //se inicia una variable llamada "CONTADOR" donde se va a ir contando el número de nodos que se han recorrido en la lista, comenzando desde cero.
        while (actual != null)
            { // Se recorre la lista mientras el nodo actual no sea null, lo que significa que aún hay nodos por recorrer en la lista.
            if (contador == indice) //si el contador es igual al índice que se quiere obtener, entonces se devuelve el dato almacenado en el nodo actual, lo que significa que se ha encontrado el nodo en la posición deseada y se retorna su contenido.
            {
                return actual.getDato(); //aca retorna el dato encontrado en el nodo "actual" que es el nodo que se encuentra en la posición del índice buscado.
            }
            actual = actual.getSiguiente(); //si el contador no es igual al índice, entonces se avanza al siguiente nodo en la lista, lo que significa que se sigue recorriendo la lista para buscar el nodo en la posición deseada.
            contador++; //se incrementa el contador en uno, lo que significa que se ha recorrido un nodo más en la lista.
        }
        return null; 
        // DEVUELVE NULL SI EL ÍNDICE ES INVÁLIDO, ES DECIR, SI NO HAY UN NODO EN ESE ÍNDICE.
    }
    @Override //les pongo el OVERRIDE para indicar que estoy sobreescribiendo el método definido en la interfaz TDALista.
    public T eliminar(int indice) 
    {
        if (primero == null) 
        {
            return null; // La lista está vacía, no hay nada que eliminar
        }
        if (indice == 0) 
        {
            T datoEliminado = primero.getDato(); //el primer nodo es el que se va a eliminar, entonces se guarda el dato del primer nodo en una variable llamada "datoEliminado" para poder devolverlo al final del método.
            primero = primero.getSiguiente(); // El primer nodo ahora es el siguiente
            return datoEliminado; //se devuelve el dato del nodo eliminado, lo que significa que se ha eliminado el nodo en la posición del índice cero y se retorna su contenido.
        }
        TDANodo<T> actual = primero; //se inicia una variable llamada "actual" que se establece como el primer nodo de la lista, lo que significa que se va a comenzar a recorrer la lista desde el primer nodo para buscar el nodo en la posición del índice que se desea eliminar.
        int contador = 0; //se inicia una variable llamada "contador" que se establece en cero, lo que significa que se va a contar el número de nodos que se han recorrido en la lista, comenzando desde el primer nodo.
        while (actual.getSiguiente() != null) //se recorre la lista mientras el siguiente nodo del nodo actual no sea null, lo que significa que aún hay nodos por recorrer en la lista.
        {
            if (contador == indice - 1) { // Encontramos el nodo anterior al que queremos eliminar
                T datoEliminado = actual.getSiguiente().getDato(); //se guarda el dato del nodo que se va a eliminar (el siguiente nodo del nodo actual) en una variable llamada "datoEliminado" para poder devolverlo al final del método.
                //es de tipo T porque el método eliminar devuelve un dato de tipo T, que es el tipo de dato que se almacena en la lista.
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // Saltamos el nodo a eliminar
                return datoEliminado; //se devuelve el dato del nodo eliminado, lo que significa que se ha eliminado el nodo en la posición del índice deseado y se retorna su contenido.
            }
            actual = actual.getSiguiente(); //si el contador no es igual al índice menos uno, entonces se avanza al siguiente nodo en la lista, lo que significa que se sigue recorriendo la lista para buscar el nodo en la posición deseada.
            contador++;//se incrementa el contador en uno, lo que significa que se ha recorrido un nodo más en la lista.
        }
        System.out.println("El índice es inválido, no se encontró el nodo a eliminar" );//si se sale del while sin haber encontrado el nodo a eliminar, entonces se imprime un mensaje indicando que el índice es inválido y no se encontró el nodo a eliminar, lo que significa que el índice proporcionado no corresponde a ningún nodo en la lista.
        return null;// DEVUELVE NULL SI EL ÍNDICE ES INVÁLIDO, ES DECIR, SI NO HAY UN NODO EN ESE ÍNDICE.
    }
    @Override
    public boolean eliminar(T elemento) 
    {
        if (primero == null) 
        {
            return false;
        }
        if (primero.getDato() == elemento) 
        {
            primero = primero.getSiguiente();
            return true;
        }
        TDANodo<T> actual = primero;
        while (actual.getSiguiente() != null) 
        {
            if (actual.getSiguiente().getDato() == elemento) 
            {
                actual.setSiguiente(actual.getSiguiente().getSiguiente()); // elimina el nodo
                return true; // sale directo, sin avanzar más
            }
            actual = actual.getSiguiente(); // avanzar cuando NO es el elemento
        }
        return false;
    }
    @Override
    public int tamaño()  //metodo para obtener el tamaño de la lista, es decir, el número de nodos que contiene la lista.
    {   
        int contador = 0; //se inicia una variable "CONTADOR" que se establece en cero, lo que significa que se va a contar el número de nodos en la lista, comenzando desde cero.
        TDANodo<T> actual = primero; // se define una variable "ACTUAL" que se establece como el primer nodo de la lista, lo que significa que se va a comenzar a recorrer la lista desde el primer nodo para contar el número de nodos que contiene la lista.
        while (actual != null) //se recorre la lista mientras el nodo actual no sea null, lo que significa que aún hay nodos por recorrer en la lista.
        {
            contador++;//se incrementa el contador en uno, lo que significa que se ha contado un nodo más en la lista.
            actual = actual.getSiguiente();//se avanza al siguiente nodo en la lista, lo que significa que se sigue recorriendo la lista para contar el número de nodos que contiene la lista.
        }
        return contador; // Devuelve el número de nodos en la lista, es decir, el tamaño de la lista.
    }
    @Override
    public boolean esVacia() 
    {
        return primero == null; // Devuelve true si el primer nodo es null, lo que significa que la lista está vacía, y false en caso contrario.
    }
    @Override
    public void ordenar(Comparator<T> comp) 
    {
        if (primero == null) return;//si la listra está vacía, no hay nada que ordenar, por lo que se retorna inmediatamente sin hacer nada.
        TDANodo<T> actual = primero;//comenzamos desde el primer nodo de la lista
        while (actual != null) // Bucle principal: recorre toda la lista de principio a fin. Cada iteración coloca el elemento más pequeño en la posición 'actual'
        {
            TDANodo<T> menor = actual;//"menor" guardara el vlaor del nodo que contiene el vlor mas pequeño 
            TDANodo<T> temp = actual.getSiguiente();//"temp" comienza con el nodo siguiente al acutal pra buscar el elemento mas peque;o
            while (temp != null) //mientras que "temp" no sea nuelo se va a ejecutar
            {
                if (comp.compare(temp.getDato(), menor.getDato()) < 0) //si el resultado de comparar el dato del nodo "temp" con el dato del nodo "menor" es menor que cero, significa que el dato del nodo "temp" es menor que el dato del nodo "menor", por lo que se actualiza "menor" para que apunte al nodo "temp", lo que significa que se ha encontrado un nuevo nodo con un valor más pequeño 
                {
                    menor = temp;   // se actualiza la referencia de "menor" para apuntar a ese nodo.
                }
                temp = temp.getSiguiente(); //avanzamos temp al siguiente nodo para seguir buscando
            }
        T aux = actual.getDato(); //guardamos el dato del nodo actual en una variante auxiliar
        actual.setDato(menor.getDato());// Copiamos el dato del nodo 'menor' (el más pequeño encontrado) al nodo 'actual'
        menor.setDato(aux); // Copiamos el dato original de 'actual' (guardado en 'aux') al nodo 'menor'
        actual = actual.getSiguiente();// Avanzamos 'actual' al siguiente nodo para continuar ordenando el resto de la lista

        }
    }

    public boolean insertar(int posicion, T elemento) 
    {
        TDANodo<T> nuevoNodo = new TDANodo<>(elemento);

        if (posicion == 0)
        {
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
            return true;
        }

        TDANodo<T> actual = primero;
        int contador = 0;
        while (actual != null) 
        {
            if (contador == posicion - 1)
            {
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);
                return true;
            }
            actual = actual.getSiguiente();
            contador++;
        }
        return false;
    }
}