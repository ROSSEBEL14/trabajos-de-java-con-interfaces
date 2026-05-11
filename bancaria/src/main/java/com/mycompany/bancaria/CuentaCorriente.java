package com.mycompany.bancaria;

public class CuentaCorriente implements CuentaBancaria {
    private final String numeroCuenta;
    private double saldo;
    private final double limiteSobregiro = 300.00;

    public CuentaCorriente(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    @Override
    public String depositar(double monto) {
        saldo += monto;
        return "Deposito realizado en Cuenta Corriente por S/ " + monto;
    }

    @Override
    public String retirar(double monto) {
        if (monto > saldo + limiteSobregiro) {
            return "Retiro rechazado. La Cuenta Corriente supera el limite de sobregiro.";
        }

        saldo -= monto;
        return "Retiro realizado de Cuenta Corriente por S/ " + monto;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public String obtenerResumen() {
        return "Cuenta Corriente " + numeroCuenta + " | Saldo: S/ " + String.format("%.2f", saldo);
    }
}
