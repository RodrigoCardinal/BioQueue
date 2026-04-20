package com.example.ImplementacionesTDA;

public class TDANodo<T>
{
    private T dato; // el dato que se va a almacenar en el nodo
    private TDANodo<T> siguiente; //este hace referencia al siguiente del nodo que colocamos en la lista, es decir, el nodo que le sigue al nodo actual
    // constructor para crear un nodo con un dato específico
    public TDANodo(T dato)  
    {
        this.dato = dato; // le brindamos el dato al nodo -> informacion que va a contener el nodo
        this.siguiente = null; // el siguiente nodo inicialmente es null, porque no sabemos cuál es el siguiente nodo en la lista
    }
    
    public T getDato() //getter para obtener el dato almacenado en el nodo
    { 
        return this.dato;
    }
    public T setDato(T dato) //de tipo T porque el dato que se va a establecer en el nodo puede ser de cualquier tipo, dependiendo del tipo de dato que se haya especificado al crear el nodo.
    //  En este caso se va a utilizar en la clase lista enlazada y cuando copile lo va a ver como (libro dato)
    {
        this.dato = dato; // se establece el nuevo dato en el nodo, lo que significa que se actualiza la información almacenada en el nodo con el nuevo dato proporcionado como argumento.
        return this.dato;
    }
    
    public TDANodo<T> getSiguiente() //getter para obtener el nodo siguiente al nodo actual
    {
    return this.siguiente;
    }
    public void setSiguiente(TDANodo<T> siguiente) //setter para establecer el nodo siguiente al nodo actual
    {
        this.siguiente = siguiente;
    }
}   

/*
PARA LLAMAR Y CREAR UN NODO DE ESTA CLASE SE HACE:

TDANodo<Integer> nodo1 = new TDANodo<>(5); // Crea un nodo que almacena el número 5 ->si es que queremos almacenar un int en ese nodo, entonces el tipo de dato que va a almacenar el nodo es Integer, y le pasamos el valor 5 al constructor para que lo almacene en el nodo.
TDANodo<String> nodo2 = new TDANodo<>("Hola"); // Crea un nodo que almacena la cadena "Hola" -> si queremos almacenar una cadena de texto, entonces el tipo de dato es String, y le pasamos la cadena "Hola" al constructor para que lo almacene en el nodo.
TDANodo<Double> nodo3 = new TDANodo<>(3.14); // Crea un nodo que almacena el número decimal 3.14 -> si queremos almacenar un número decimal, entonces el tipo de dato es Double, y le pasamos el valor 3.14 al constructor para que lo almacene en el nodo.
======================================================================================================================================================================================================================================================================================================
EN ESTE CASO QUE ESTAMOS TRABAJANDO CON LIBROS, SI QUEREMOS CREAR UN NODO QUE ALMACENE UN OBJETO DE TIPO LIBRO, ENTONCES EL TIPO DE DATO ES LIBRO, Y LE PASAMOS UN NUEVO OBJETO DE TIPO LIBRO AL CONSTRUCTOR PARA QUE LO ALMACENE EN EL NODO:
TDANodo<libro> nodo4 = new TDANodo<>(new libro("001", "Java", 29.99, 5)); // Crea un nodo que almacena un objeto de tipo libro -> si queremos almacenar un objeto de tipo libro, entonces el tipo de dato es libro, y le pasamos un nuevo objeto libro al constructor para que lo almacene en el nodo.
*/