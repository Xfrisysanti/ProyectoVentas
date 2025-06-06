
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Clientes;
import fiuni.edu.py.Repositorios.RepositorioClientes;

import java.util.List;

/**
 * Controlador encargado de manejar las operaciones relacionadas con los
 * clientes. Actúa como intermediario entre la vista y el repositorio de
 * clientes.
 *
 * @author luisf
 */
public class ControladorClientes {

    private final RepositorioClientes repo = new RepositorioClientes();

    /**
     * Agrega un nuevo cliente al repositorio.
     *
     * @param identificacion Identificación única del cliente.
     * @param nombre Nombre del cliente.
     * @param edad Edad del cliente.
     * @param email Email del cliente
     */
    public void agregarCliente(int identificacion, String nombre, int edad, String email) {
        Clientes cliente = new Clientes(identificacion, nombre, edad, email);
        repo.guardar(cliente);
    }

    /**
     * Edita los datos de un cliente existente en el repositorio.
     *
     * @param identificacion Identificación del cliente a editar.
     * @param nuevoNombre Nuevo nombre que se asignará al cliente.
     * @param nuevaEdad Nueva edad que se asignará al cliente.
     * @param nuevoEmail Nuevo email del cliente
     *
     */
    public void editarCliente(int identificacion, String nuevoNombre, int nuevaEdad, String nuevoEmail) {
        Clientes cliente = repo.buscarPorIdentificacion(identificacion);
        cliente.setNombre(nuevoNombre);
        cliente.setEdad(nuevaEdad);
        cliente.setEmail(nuevoEmail);
        repo.editar(cliente);

    }

    /**
     * Elimina un cliente del repositorio por su identificación.
     *
     * @param identificacion Identificación del cliente a eliminar.
     *
     */
    public void eliminarCliente(int identificacion) {
        repo.eliminar(identificacion);
    }

    /**
     * Busca un cliente en el repositorio por su identificación.
     *
     * @param identificacion Identificación del cliente a buscar.
     * @return El cliente encontrado, o {@code null} si no existe.
     */
    public Clientes buscarCliente(int identificacion) {
        return repo.buscarPorIdentificacion(identificacion);
    }

    /**
     * Obtiene una lista con todos los clientes almacenados en el repositorio.
     *
     * @return Lista de clientes.
     */
    public List<Clientes> listarClientes() {
        return repo.listarTodos();
    }

    /**
     * Obtiene el correo electrónico (Gmail) de una persona a partir de su
     * identificación.
     *
     * @param id Identificación de la persona.
     * @return El correo electrónico de la persona.
     */
    public String getGmail(int id) {
        return repo.buscarPorIdentificacion(id).getEmail();
    }

    /**
     * Obtiene la edad de una persona a partir de su identificación.
     *
     * @param id Identificación de la persona.
     * @return La edad de la persona.
     */
    public int getEdad(int id) {
        return repo.buscarPorIdentificacion(id).getEdad();
    }

    /**
     * Obtiene el nombre de una persona a partir de su identificación.
     *
     * @param id Identificación de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre(int id) {
        return repo.buscarPorIdentificacion(id).getNombre();
    }

}
