package com.example;

public class Trasplante {
    private Donante donante;
    private Receptor receptor;
    public Trasplante(Donante donante, Receptor receptor) {
        this.donante=donante;
        this.receptor=receptor;
    }
    public Donante getDonante(){
        return(donante);
    }
    public Receptor getReceptor() {
        return(receptor);
    }
}
