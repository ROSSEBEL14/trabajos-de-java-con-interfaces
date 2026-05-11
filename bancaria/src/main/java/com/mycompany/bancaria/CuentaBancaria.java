package com.mycompany.bancaria;

public interface CuentaBancaria {
    String depositar(double monto);

    String retirar(double monto);

    double getSaldo();
}
