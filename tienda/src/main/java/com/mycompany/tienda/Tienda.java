package com.mycompany.tienda;

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

public class Tienda {
    private final Cliente cliente = new Cliente("Cliente invitado", "Sin telefono");
    private final JTextArea salida = new JTextArea();
    private final JTextField campoCliente = new JTextField("Cliente invitado");
    private final JTextField campoTelefono = new JTextField("Sin telefono");
    private final JTextField campoNombreMascota = new JTextField();
    private final JTextField campoEdad = new JTextField();
    private final JTextField campoRaza = new JTextField();
    private final JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Perro", "Gato"});

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Tienda().crearVentana());
    }

    private void crearVentana() {
        JFrame ventana = new JFrame("Tienda de Mascotas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(680, 520);
        ventana.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Registro de Tienda de Mascotas", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        salida.setEditable(false);
        salida.setLineWrap(true);
        salida.setWrapStyleWord(true);
        salida.setText("Registre un cliente y sus mascotas.");

        JPanel formulario = new JPanel(new GridLayout(7, 2, 10, 10));
        formulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        formulario.add(new JLabel("Nombre del cliente:"));
        formulario.add(campoCliente);
        formulario.add(new JLabel("Telefono:"));
        formulario.add(campoTelefono);
        formulario.add(new JLabel("Tipo de mascota:"));
        formulario.add(comboTipo);
        formulario.add(new JLabel("Nombre de mascota:"));
        formulario.add(campoNombreMascota);
        formulario.add(new JLabel("Edad:"));
        formulario.add(campoEdad);
        formulario.add(new JLabel("Raza:"));
        formulario.add(campoRaza);

        JButton botonAgregar = new JButton("Agregar Mascota");
        JButton botonMostrar = new JButton("Mostrar Registro");
        formulario.add(botonAgregar);
        formulario.add(botonMostrar);

        botonAgregar.addActionListener(e -> agregarMascota());
        botonMostrar.addActionListener(e -> mostrarRegistro());

        ventana.add(titulo, BorderLayout.NORTH);
        ventana.add(formulario, BorderLayout.CENTER);
        ventana.add(new JScrollPane(salida), BorderLayout.SOUTH);
        ventana.setVisible(true);
    }

    private void agregarMascota() {
        String nombreCliente = campoCliente.getText().trim();
        String telefono = campoTelefono.getText().trim();
        String nombreMascota = campoNombreMascota.getText().trim();
        String raza = campoRaza.getText().trim();
        int edad;

        if (nombreCliente.isEmpty() || telefono.isEmpty() || nombreMascota.isEmpty() || raza.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            return;
        }

        try {
            edad = Integer.parseInt(campoEdad.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La edad debe ser un numero entero.");
            return;
        }

        cliente.setNombre(nombreCliente);
        cliente.setTelefono(telefono);

        Mascota mascota;
        if ("Perro".equals(comboTipo.getSelectedItem())) {
            mascota = new Perro(nombreMascota, edad, raza);
        } else {
            mascota = new Gato(nombreMascota, edad, raza);
        }

        cliente.agregarMascota(mascota);
        salida.setText("Mascota agregada:\n" + mascota.obtenerFicha());
        limpiarCamposMascota();
    }

    private void mostrarRegistro() {
        salida.setText(cliente.obtenerRegistro());
    }

    private void limpiarCamposMascota() {
        campoNombreMascota.setText("");
        campoEdad.setText("");
        campoRaza.setText("");
    }
}
