
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

    private final RepositorioClientes repo;

    /**
     * Constructor del controlador que recibe una instancia del repositorio de
     * clientes.
     *
     * @param repo Repositorio que se utilizará para acceder a los datos de los
     * clientes.
     */
    public ControladorClientes(RepositorioClientes repo) {
        this.repo = repo;
    }

    /**
     * Agrega un nuevo cliente al repositorio.
     *
     * @param identificacion Identificación única del cliente.
     * @param nombre Nombre del cliente.
     * @param edad Edad del cliente.
     * @return El cliente que fue agregado al repositorio.
     */
    public Clientes agregarCliente(int identificacion, String nombre, int edad) {
        Clientes cliente = new Clientes(identificacion, nombre, edad);
        return repo.guardar(cliente);
    }

    /**
     * Edita los datos de un cliente existente en el repositorio.
     *
     * @param identificacion Identificación del cliente a editar.
     * @param nuevoNombre Nuevo nombre que se asignará al cliente.
     * @param nuevaEdad Nueva edad que se asignará al cliente.
     * @return {@code true} si la edición fue exitosa; {@code false} si el
     * cliente no fue encontrado.
     */
    public boolean editarCliente(int identificacion, String nuevoNombre, int nuevaEdad) {
        Clientes cliente = repo.buscarPorIdentificacion(identificacion);
        if (cliente != null) {
            cliente.setNombre(nuevoNombre);
            cliente.setEdad(nuevaEdad);
            return repo.editar(cliente);
        }
        return false;
    }

    /**
     * Elimina un cliente del repositorio por su identificación.
     *
     * @param identificacion Identificación del cliente a eliminar.
     * @return {@code true} si el cliente fue eliminado exitosamente;
     * {@code false} en caso contrario.
     */
    public boolean eliminarCliente(int identificacion) {
        return repo.eliminar(identificacion);
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
}
