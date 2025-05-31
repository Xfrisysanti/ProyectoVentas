/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Repositorios;

import fiuni.edu.py.Modelo.Clientes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author santi
 */
/**
 * Repositorio que gestiona operaciones CRUD (crear, leer, actualizar, eliminar)
 * sobre objetos de tipo {@link Cliente}, utilizando una estructura 
 * de tipo mapa.
 * La clave utilizada es la identificación única de cada cliente.
 * 
 * @author luisf
 */
public class RepositorioClientes {

    /** Mapa que almacena los clientes con su identificación como clave */
    private static final Map<Integer, Clientes> clientes = new HashMap<>();

    /**
     * Guarda un nuevo cliente o actualiza uno existente si la identificación ya está registrada.
     * 
     * @param cliente Cliente a guardar
     * @return El cliente guardado
     */
    public Clientes guardar(Clientes cliente) {
        clientes.put(cliente.getIdentificacion(), cliente);
        return cliente;
    }

    /**
     * Busca un cliente por su identificación.
     * 
     * @param identificacion Identificación del cliente a buscar
     * @return El cliente correspondiente o {@code null} si no se encuentra
     */
    public Clientes buscarPorIdentificacion(int identificacion) {
        return clientes.get(identificacion);
    }

    /**
     * Elimina un cliente según su identificación.
     * 
     * @param identificacion Identificación del cliente a eliminar
     * @return {@code true} si el cliente fue eliminado, {@code false} si no existía
     */
    public boolean eliminar(int identificacion) {
        return clientes.remove(identificacion) != null;
    }

    /**
     * Lista todos los clientes almacenados en el repositorio.
     * 
     * @return Lista con todos los clientes
     */
    public List<Clientes> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    /**
     * Edita un cliente existente, reemplazándolo con una nueva versión del objeto.
     * 
     * @param clienteEditado Objeto cliente con los datos actualizados
     * @return {@code true} si se realizó la edición, {@code false} si el cliente no existe
     */
    public boolean editar(Clientes clienteEditado) {
        if (clientes.containsKey(clienteEditado.getIdentificacion())) {
            clientes.put(clienteEditado.getIdentificacion(), clienteEditado);
            return true;
        }
        return false;
    }
}
