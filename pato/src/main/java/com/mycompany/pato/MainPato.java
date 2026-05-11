package com.mycompany.pato;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainPato {
    public static void main(String[] args) {
        EventQueue.invokeLater(MainPato::crearVentana);
    }

    private static void crearVentana() {
        Pato pato = new Pato();

        JFrame ventana = new JFrame("Herencia Multiple con Interfaces");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 320);
        ventana.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Pato: Volador y Nadador", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JTextArea estado = new JTextArea();
        estado.setEditable(false);
        estado.setText("Seleccione una accion para simular el comportamiento del pato.");
        estado.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton botonVolar = new JButton("Volar");
        JButton botonNadar = new JButton("Nadar");

        botonVolar.addActionListener(e -> estado.setText(pato.volar()));
        botonNadar.addActionListener(e -> estado.setText(pato.nadar()));

        panelBotones.add(botonVolar);
        panelBotones.add(botonNadar);

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(estado, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
}
