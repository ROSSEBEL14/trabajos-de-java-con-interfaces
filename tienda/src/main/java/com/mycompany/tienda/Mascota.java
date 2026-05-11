package com.mycompany.tienda;

public abstract class Mascota {
    private final String nombre;
    private final int edad;
    private final String raza;

    public Mascota(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getRaza() {
        return raza;
    }

    public abstract String hacerSonido();

    public String obtenerFicha() {
        return "Tipo: " + getClass().getSimpleName()
                + "\nNombre: " + nombre
                + "\nEdad: " + edad
                + "\nRaza: " + raza
                + "\nSonido: " + hacerSonido();
    }
}
