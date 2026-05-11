package com.mycompany.tienda;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String telefono;
    private final List<Mascota> mascotas = new ArrayList<>();

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
    }

    public String obtenerRegistro() {
        StringBuilder registro = new StringBuilder();
        registro.append("Cliente: ").append(nombre).append("\n");
        registro.append("Telefono: ").append(telefono).append("\n");
        registro.append("Mascotas registradas: ").append(mascotas.size()).append("\n\n");

        if (mascotas.isEmpty()) {
            registro.append("No hay mascotas registradas.");
            return registro.toString();
        }

        for (Mascota mascota : mascotas) {
            registro.append(mascota.obtenerFicha()).append("\n\n");
        }

        return registro.toString();
    }
}
