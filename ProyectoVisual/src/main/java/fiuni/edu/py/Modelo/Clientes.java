/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Modelo;

import java.io.Serializable;

/**
 * Representa a un cliente con su identificación, nombre y edad
 * Usado para registrar y gestionar los datos de los clientes en el sistema
 * de ventas
 * 
 * @author luisf
 */
public class Clientes implements Serializable{

    /** Identificación única del cliente */
    private int identificacion;

    /** Nombre del cliente */
    private String nombre;

    /** Edad del cliente */
    private int edad;
    
    /** Email del cliente*/
    private String email;

    /**
     * Crea un nuevo cliente con los datos especificados.
     * 
     * @param identificacion Identificación única del cliente
     * @param nombre Nombre del cliente
     * @param edad Edad del cliente
     * @param email Email del cliente
     */
    public Clientes(int identificacion, String nombre, int edad, String email) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }
    
    /**
     * Obtiene el email del cliente.
     * 
     * @return email del cliente
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
     * Obtiene la identificación del cliente.
     * 
     * @return Identificación del cliente
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación del cliente.
     * 
     * @param identificacion Nueva identificación del cliente
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del cliente.
     * 
     * @return Edad del cliente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del cliente.
     * 
     * @param edad Nueva edad del cliente
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una representación en forma de cadena del cliente.
     * 
     * @return Cadena que representa al cliente
     */
    @Override
    public String toString() {
        return "Cliente{"
                + "identificación=" + identificacion
                + ", nombre='" + nombre + '\''
                + ", edad=" + edad
                + '}';
    }

}