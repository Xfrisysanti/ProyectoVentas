/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Repositorios;

import fiuni.edu.py.Modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repositorio que gestiona operaciones CRUD (crear, leer, actualizar, eliminar)
 * para objetos de tipo {@link Producto}, utilizando una estructura 
 * de tipo mapa.
 * Este repositorio asigna automáticamente un ID único a cada producto 
 * registrado.
 * 
 * @author luisf
 */
public class RepositorioProducto {

    /** Mapa que almacena productos con su ID como clave */
    private static final Map<Integer, Producto> productos = new HashMap<>();

    /** Identificador actual para asignar automáticamente a nuevos productos */
    private static int idActual = 1000;

    /**
     * Guarda un nuevo producto, asignándole un ID único automáticamente.
     * 
     * @param producto Producto a guardar
     * @return El producto guardado con su ID asignado
     */
    public Producto guardar(Producto producto) {
        producto.setIdProducto(idActual++);
        productos.put(producto.getIdProducto(), producto);
        return producto;
    }
    public int conseguirID(){
        return idActual;
    }
    /**
     * Busca un producto por su ID.
     * 
     * @param id Identificador del producto
     * @return El producto correspondiente o {@code null} si no se encuentra
     */
    public Producto buscarPorId(int id) {
        return productos.get(id);
    }

    /**
     * Elimina un producto del repositorio según su ID.
     * 
     * @param id Identificador del producto a eliminar
     * @return {@code true} si el producto fue eliminado, {@code false} si no existía
     */
    public boolean eliminar(int id) {
        return productos.remove(id) != null;
    }

    /**
     * Lista todos los productos almacenados en el repositorio.
     * 
     * @return Lista con todos los productos registrados
     */
    public List<Producto> listarTodos() {
        return new ArrayList<>(productos.values());
    }

    /**
     * Edita un producto existente en el repositorio, reemplazándolo por una nueva versión.
     * 
     * @param productoEditado Producto con los datos actualizados
     * @return {@code true} si se actualizó el producto, {@code false} si no existía
     */
    public boolean editar(Producto productoEditado) {
        if (productos.containsKey(productoEditado.getIdProducto())) {
            productos.put(productoEditado.getIdProducto(), productoEditado);
            return true;
        }
        return false;
    }
}
