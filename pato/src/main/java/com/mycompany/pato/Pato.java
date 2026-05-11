package com.mycompany.pato;


public class Pato implements Volador, Nadador {
    @Override
    public String volar() {
        return "El pato esta volando con sus alas.";
    }

    @Override
    public String nadar() {
        return "El pato esta nadando en el agua.";
    }
}
