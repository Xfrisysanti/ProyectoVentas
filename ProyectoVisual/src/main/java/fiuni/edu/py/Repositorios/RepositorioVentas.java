/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Repositorios;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Modelo.Ventas;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.time.LocalDate;

/**
 * Repositorio que gestiona operaciones CRUD para objetos de tipo {@link Venta}.
 * Utiliza un mapa para almacenar las ventas con su ID como clave, y permite
 * también realizar búsquedas filtradas por fechas.
 *
 * @author luisf
 */
public class RepositorioVentas {
    private static final String ARCHIVO = "ventas.dat";
    /**
     * Mapa que almacena las ventas registradas, usando su ID como clave
     */
    private static final Map<Integer, Ventas> ventas = new HashMap<>();

    /**
     * ID actual para asignar automáticamente a nuevas ventas
     */
    private int idActual = 1;
    private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(ventas);
            out.writeInt(idActual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar datos desde el archivo binario al iniciar el repositorio
    private void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Map<Integer,Ventas> datosCargados = (Map<Integer, Ventas>) in.readObject();
            ventas.putAll(datosCargados);
            idActual = in.readInt(); // Recuperar el último ID usado
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error, el archivo puede no existir aún, entonces mantenemos el mapa vacío
        }
    }
    /**
     * Guarda una nueva venta en el repositorio, asignándole un ID único.
     *
     * @param venta Venta a guardar
     * @return La venta guardada con su ID asignado
     */
    public Ventas guardar(Ventas venta) {
        venta.setIdVenta(idActual++);
        ventas.put(venta.getIdVenta(), venta);
         guardarDatos();
        return venta;
    }

    /**
     * Busca una venta por su ID.
     *
     * @param id Identificador de la venta
     * @return La venta correspondiente o {@code null} si no se encuentra
     */
    public Ventas buscarPorId(int id) {
        return ventas.get(id);
    }

    /**
     * Elimina una venta del repositorio por su ID.
     *
     * @param id Identificador de la venta a eliminar
     * @return {@code true} si se eliminó la venta, {@code false} si no existía
     */
    public void eliminar(int id) {
        ventas.remove(id);
         guardarDatos();
    }

    /**
     * Lista todas las ventas registradas en el repositorio.
     *
     * @return Lista con todas las ventas almacenadas
     */
    public List<Ventas> listarTodos() {
        return new ArrayList<>(ventas.values());
    }

    /**
     * Filtra las ventas realizadas entre dos fechas.
     *
     * @param desde Fecha de inicio del rango
     * @param hasta Fecha de fin del rango
     * @return Lista de ventas realizadas entre las fechas especificadas
     */
    public List<Ventas> ventasEntreFechas(LocalDate desde, LocalDate hasta) {
        List<Ventas> resultado = new ArrayList<>();
        for (Ventas venta : ventas.values()) {
            if (!venta.getFechaVenta().isBefore(desde) && !venta.getFechaVenta().isAfter(hasta)) {
                resultado.add(venta);
            }
        }
        return resultado;
    }
}
