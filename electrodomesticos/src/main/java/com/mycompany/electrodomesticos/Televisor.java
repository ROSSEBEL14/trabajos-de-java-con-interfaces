package com.mycompany.electrodomesticos;

public class Televisor implements Electrodomestico {
    @Override
    public String encender() {
        return "El televisor esta encendido.";
    }

    @Override
    public String apagar() {
        return "El televisor esta apagado.";
    }
}