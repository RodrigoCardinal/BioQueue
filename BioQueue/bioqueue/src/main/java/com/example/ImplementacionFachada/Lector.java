package com.example.ImplementacionFachada;

import java.util.Scanner;

public class Lector implements ILector{
    private Scanner sc = new Scanner(System.in);
    public String leerLinea() {
        return(sc.nextLine());
    }
}
