package com.mycompany.electrodomesticos;

public class Refrigerador implements Electrodomestico {
    @Override
    public String encender() {
        return "El refrigerador esta encendido.";
    }

    @Override
    public String apagar() {
        return "El refrigerador esta apagado.";
    }
}