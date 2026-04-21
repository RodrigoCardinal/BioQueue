package com.example;

public class Transplante {
    Donante donante;
    Receptor receptor;
    public Transplante(Donante donante, Receptor receptor) {
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
