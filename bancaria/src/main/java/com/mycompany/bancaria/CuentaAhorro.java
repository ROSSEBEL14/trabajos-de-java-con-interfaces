package com.mycompany.bancaria;

public class CuentaAhorro implements CuentaBancaria {
    private final String numeroCuenta;
    private double saldo;

    public CuentaAhorro(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    @Override
    public String depositar(double monto) {
        saldo += monto;
        return "Deposito realizado en Cuenta Ahorro por S/ " + monto;
    }

    @Override
    public String retirar(double monto) {
        if (monto > saldo) {
            return "Retiro rechazado. La Cuenta Ahorro no permite sobregiro.";
        }

        saldo -= monto;
        return "Retiro realizado de Cuenta Ahorro por S/ " + monto;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public String obtenerResumen() {
        return "Cuenta Ahorro " + numeroCuenta + " | Saldo: S/ " + String.format("%.2f", saldo);
    }
}
