package com.example.ImplementacionesTDA;

public class Cola<T> implements TDACola<T> {

    private TDANodo<T> frente;
    private TDANodo<T> fin;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }


    @Override
    public void encolar(T dato) {
        TDANodo<T> nuevo = new TDANodo<>(dato);
        if (esVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tamaño++;
    }

    @Override
    public T desencolar() {
        if (esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamaño--;
        return dato;
    }

    @Override
    public T frente() {
        if (esVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return frente.getDato();
    }

    @Override
    public boolean esVacia() {
        return frente == null;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

}
   