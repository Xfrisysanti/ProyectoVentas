/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectovisual;

/**
 * Clase principal del proyecto.
 *
 * Esta clase contiene el método main, que sirve como punto de entrada para la
 * aplicación. Al ejecutarse, inicializa y muestra la ventana del menú
 * principal.
 *
 * Autor: luisf
 */
public class ProyectoVisual {

    /**
     * Método principal de la aplicación.
     *
     * Este método lanza la interfaz gráfica mostrando el menú principal al
     * usuario.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este
     * proyecto).
     */
    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);// Muestra la ventana principal
    }
}
