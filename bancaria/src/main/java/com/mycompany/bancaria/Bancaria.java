package com.mycompany.bancaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bancaria {
    private final CuentaCorriente cuentaCorriente = new CuentaCorriente("001-CC", 500.00);
    private final CuentaAhorro cuentaAhorro = new CuentaAhorro("002-CA", 1000.00);
    private final JComboBox<String> comboCuenta = new JComboBox<>(new String[]{"Cuenta Corriente", "Cuenta Ahorro"});
    private final JTextField campoMonto = new JTextField();
    private final JTextArea salida = new JTextArea();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Bancaria().crearVentana());
    }

    private void crearVentana() {
        JFrame ventana = new JFrame("Aplicacion Bancaria");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(620, 420);
        ventana.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Uso de Interfaces en una Aplicacion Bancaria", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JPanel formulario = new JPanel(new GridLayout(4, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formulario.add(new JLabel("Seleccione cuenta:"));
        formulario.add(comboCuenta);
        formulario.add(new JLabel("Monto:"));
        formulario.add(campoMonto);

        JButton botonDepositar = new JButton("Depositar");
        JButton botonRetirar = new JButton("Retirar");
        JButton botonSaldos = new JButton("Ver Saldos");
        JButton botonLimpiar = new JButton("Limpiar");

        formulario.add(botonDepositar);
        formulario.add(botonRetirar);
        formulario.add(botonSaldos);
        formulario.add(botonLimpiar);

        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setText(obtenerSaldos());

        botonDepositar.addActionListener(e -> realizarDeposito());
        botonRetirar.addActionListener(e -> realizarRetiro());
        botonSaldos.addActionListener(e -> salida.setText(obtenerSaldos()));
        botonLimpiar.addActionListener(e -> campoMonto.setText(""));

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(formulario, BorderLayout.CENTER);
        ventana.add(new JScrollPane(salida), BorderLayout.SOUTH);
        ventana.setVisible(true);
    }

    private void realizarDeposito() {
        CuentaBancaria cuenta = obtenerCuentaSeleccionada();
        Double monto = leerMonto();

        if (monto == null) {
            return;
        }

        salida.setText(cuenta.depositar(monto) + "\n\n" + obtenerSaldos());
        campoMonto.setText("");
    }

    private void realizarRetiro() {
        CuentaBancaria cuenta = obtenerCuentaSeleccionada();
        Double monto = leerMonto();

        if (monto == null) {
            return;
        }

        salida.setText(cuenta.retirar(monto) + "\n\n" + obtenerSaldos());
        campoMonto.setText("");
    }

    private CuentaBancaria obtenerCuentaSeleccionada() {
        if ("Cuenta Corriente".equals(comboCuenta.getSelectedItem())) {
            return cuentaCorriente;
        }

        return cuentaAhorro;
    }

    private Double leerMonto() {
        try {
            double monto = Double.parseDouble(campoMonto.getText().trim());

            if (monto <= 0) {
                JOptionPane.showMessageDialog(null, "El monto debe ser mayor que cero.");
                return null;
            }

            return monto;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un monto valido.");
            return null;
        }
    }

    private String obtenerSaldos() {
        return cuentaCorriente.obtenerResumen() + "\n" + cuentaAhorro.obtenerResumen();
    }
}
