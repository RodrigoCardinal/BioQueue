package com.example.ImplementacionesTDA;

interface TDACola<T> {
    void encolar(T elemento);
    T desencolar();
    T frente();
    boolean esVacia();
    int tamaño();
}