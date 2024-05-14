/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Presentacion;

/**
 * Clase para correr el metodo estableciendo la cedula solamente por falta de integrecion al caso principal
 * @author JESUS
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cedula="CED123456789";
        frmGestionPrincipal c=new frmGestionPrincipal(cedula);
        c.setVisible(true);
    }
    
}
