package com.mycompany.tienda;

public class Gato extends Mascota {
    public Gato(String nombre, int edad, String raza) {
        super(nombre, edad, raza);
    }

    @Override
    public String hacerSonido() {
        return "Miau";
    }
}
