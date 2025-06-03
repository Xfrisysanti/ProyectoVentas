/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Repositorios;

import fiuni.edu.py.Modelo.ItemVenta;
import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Modelo.Ventas;
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
 * Repositorio para gestionar las ventas que han sido eliminadas del sistema.
 * Permite almacenar, cargar y listar ventas eliminadas, así como calcular el
 * total de una venta específica.
 *
 * Los datos se almacenan de forma persistente en un archivo binario.
 *
 * @author santi
 */
public class RepositorioVentasEliminadas {

    /**
     * Nombre del archivo donde se almacenan las ventas eliminadas.
     */
    private static final String ARCHIVO = "ventasEliminadas.dat";
    /**
     * Repositorio de productos para recuperar información del producto en las
     * ventas.
     */
    RepositorioProducto productoRepo = new RepositorioProducto();
    /**
     * Mapa que almacena las ventas eliminadas, usando como clave un ID
     * incremental.
     */
    private static final Map<Integer, Ventas> ventasEliminadas = new HashMap<>();
    /**
     * ID actual que se asignará a la próxima venta eliminada.
     */
    private static int idActual = 1000;

    /**
     * Guarda los datos actuales del repositorio (ventas eliminadas e ID actual)
     * en un archivo binario.
     */
    private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(ventasEliminadas);
            out.writeInt(idActual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga los datos del archivo binario al iniciar el repositorio. Si el
     * archivo no existe o hay un error, el mapa se mantiene vacío.
     */
    private void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Map<Integer, Ventas> datosCargados = (Map<Integer, Ventas>) in.readObject();
            ventasEliminadas.putAll(datosCargados);
            idActual = in.readInt(); // Recuperar el último ID usado
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error, el archivo puede no existir aún, entonces mantenemos el mapa vacío
        }
    }

    /**
     * Agrega una nueva venta eliminada al repositorio y guarda los datos en el
     * archivo.
     *
     * @param ventaEliminada La venta que ha sido eliminada.
     */
    public void agregarEventaEliminada(Ventas ventaEliminada) {
        ventasEliminadas.put(idActual, ventaEliminada);
        idActual++;
        guardarDatos();
    }

    /**
     * Lista todas las ventas que han sido eliminadas.
     *
     * @return Una lista de todas las ventas eliminadas.
     */
    public List<Ventas> listarTodas() {
        return new ArrayList<>(ventasEliminadas.values());
    }

    /**
     * Calcula el total de una venta en base a los productos y sus cantidades.
     * Tiene en cuenta si el producto se vende por unidad o por peso.
     *
     * @param venta La venta a la que se le desea calcular el total.
     * @return El valor total de la venta.
     */
    public double calcularTotalVenta(Ventas venta) {
        double total = 0.0;
        List<ItemVenta> items = venta.getItems();

        for (ItemVenta item : items) {
            Producto producto = productoRepo.buscarPorId(item.getProductoId());

            if (producto != null) {
                if (producto.getPeso() == -1) {
                    // Producto vendido por unidad
                    total += item.getCantidadUnidad() * producto.getPrecio();
                } else {
                    // Producto vendido por peso
                    total += item.getCantidadPeso() * producto.getPrecio();
                }
            }
        }

        return total;
    }
}
