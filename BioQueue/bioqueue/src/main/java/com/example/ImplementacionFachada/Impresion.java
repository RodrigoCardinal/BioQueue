package com.example.ImplementacionFachada;

public class Impresion implements IImpresion{
    public void imprimir(String s) {
        System.out.print(s);
    }
}
