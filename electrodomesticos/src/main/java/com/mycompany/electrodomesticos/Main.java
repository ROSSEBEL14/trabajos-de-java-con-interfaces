package com.mycompany.electrodomesticos;

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

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(Main::crearVentana);
    }

    private static void crearVentana() {
        Electrodomestico televisor = new Televisor();
        Electrodomestico refrigerador = new Refrigerador();

        JFrame ventana = new JFrame("Control de Electrodomesticos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 350);
        ventana.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Interface Electrodomestico", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JTextArea estado = new JTextArea();
        estado.setEditable(false);
        estado.setText("Seleccione una opcion para controlar los electrodomesticos.");
        estado.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton encenderTelevisor = new JButton("Encender Televisor");
        JButton apagarTelevisor = new JButton("Apagar Televisor");
        JButton encenderRefrigerador = new JButton("Encender Refrigerador");
        JButton apagarRefrigerador = new JButton("Apagar Refrigerador");

        encenderTelevisor.addActionListener(e -> estado.setText(televisor.encender()));
        apagarTelevisor.addActionListener(e -> estado.setText(televisor.apagar()));
        encenderRefrigerador.addActionListener(e -> estado.setText(refrigerador.encender()));
        apagarRefrigerador.addActionListener(e -> estado.setText(refrigerador.apagar()));

        panelBotones.add(encenderTelevisor);
        panelBotones.add(apagarTelevisor);
        panelBotones.add(encenderRefrigerador);
        panelBotones.add(apagarRefrigerador);

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(estado, BorderLayout.CENTER);
        ventana.add(panelBotones, BorderLayout.SOUTH);
        ventana.setVisible(true);
    }
}
