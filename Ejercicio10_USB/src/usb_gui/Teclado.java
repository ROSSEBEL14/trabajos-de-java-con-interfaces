/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usb_gui;

/**
 *
 * @author USUARIO
 */
public class Teclado implements DispositivoUSB {
    @Override
    public String Conectar()
    {
        return("Teclado Conectado");
    }
    
    @Override
    public String Desconectar()
    {
        return("Teclaso Desconectado");
    }
}
