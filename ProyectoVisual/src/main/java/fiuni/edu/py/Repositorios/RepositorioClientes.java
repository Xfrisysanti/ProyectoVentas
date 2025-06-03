/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Repositorios;

import fiuni.edu.py.Modelo.Clientes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repositorio que gestiona operaciones CRUD (crear, leer, actualizar, eliminar)
 * sobre objetos de tipo {@link Cliente}, utilizando una estructura de tipo
 * mapa. La clave utilizada es la identificación única de cada cliente.
 *
 * @author luisf
 */
public class RepositorioClientes {

    private static final String ARCHIVO = "clientes.dat";
    /**
     * Mapa que almacena los clientes con su identificación como clave
     */
    private static final Map<Integer, Clientes> clientes = new HashMap<>();

    public RepositorioClientes() {
        cargarDatos();
    }

    // Método para guardar datos en un archivo binario
    private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar datos desde el archivo binario al iniciar el repositorio
    private void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Map<Integer, Clientes> datosCargados = (Map<Integer, Clientes>) in.readObject();
            clientes.putAll(datosCargados);
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error, el archivo puede no existir aún, entonces mantenemos el mapa vacío
        }
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente si la identificación ya
     * está registrada.
     *
     * @param cliente Cliente a guardar
     *
     */
    public void guardar(Clientes cliente) {
        clientes.put(cliente.getIdentificacion(), cliente);
        guardarDatos();
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
     */
    public void eliminar(int identificacion) {
        clientes.remove(identificacion);
        guardarDatos();
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
     * Edita un cliente existente, reemplazándolo con una nueva versión del
     * objeto.
     *
     * @param clienteEditado Objeto cliente con los datos actualizados
     */
    public void editar(Clientes clienteEditado) {
        clientes.put(clienteEditado.getIdentificacion(), clienteEditado);
        guardarDatos();

    }
}
