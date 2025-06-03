
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Modelo.Ventas;
import fiuni.edu.py.Modelo.ItemVenta;
import fiuni.edu.py.Repositorios.RepositorioProducto;
import fiuni.edu.py.Repositorios.RepositorioVentas;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con las
 * ventas, incluyendo el registro, eliminación, cálculo de totales y consultas
 * por fechas. Se comunica con los repositorios de ventas, clientes y productos.
 *
 * @author luisf
 */
public class ControladorVentas {

    public ControladorVentas() {
    }
    /**Repositorio de ventas*/
    private final RepositorioVentas ventaRepo = new RepositorioVentas();
    /**Repositorio de productos*/
    private final RepositorioProducto productoRepo = new RepositorioProducto();
    /**
     * Controlador encargado de gestionar las operaciones relacionadas con los
     * productos.
     */
    private final ControladorProducto controladorProducto = new ControladorProducto();
    
    /**
     * Guarda una venta en el repositorio.
     *
     * @param venta que se desea guardar.
     */
    public void registrarVenta(Ventas venta) {
        ventaRepo.guardar(venta);
    }

    /**
     * Devuelve una lista con todas las ventas registradas.
     *
     * @return Lista de ventas.
     */
    public List<Ventas> listarVentas() {
        return ventaRepo.listarTodos();
    }

    /**
     * Elimina una venta por su identificador
     *
     * @param id
     */
    public void eliminarVenta(int id) {
        ventaRepo.eliminar(id);
    }

    /**
     * Calcula el total de una venta dada la lista de ítems.Omite productos no
     * encontrados.
     *
     * @param venta
     * @return Total calculado de la venta.
     */
    public double calcularTotalVenta(Ventas venta) {
        double total = 0.0;
        List<ItemVenta> items = venta.getItems();

        for (ItemVenta item : items) {
            Producto producto = controladorProducto.buscarProducto(item.getProductoId());

            if (producto.getPeso() == -1) {
                // Producto vendido por unidad
                total += item.getCantidadUnidad() * producto.getPrecio();
            } else {
                // Producto vendido por peso
                total += item.getCantidadPeso() * producto.getPrecio();
            }

        }

        return total;
    }

    /**
     * Obtiene todas las ventas realizadas entre dos fechas específicas
     * (inclusive).
     *
     * @param desde Fecha inicial.
     * @param hasta Fecha final.
     * @return Lista de ventas realizadas en el rango especificado.
     */
    public List<Ventas> getVentasEntreFechas(LocalDate desde, LocalDate hasta) {
        return ventaRepo.ventasEntreFechas(desde, hasta);
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id Identificador del producto.
     * @return El producto correspondiente o {@code null} si no se encuentra.
     */
    public Producto getProductoPorId(int id) {
        return productoRepo.buscarPorId(id);
    }

    /**
     * Busca una venta por su identificador.
     *
     * @param id Identificador de la venta.
     * @return La venta encontrada o {@code null} si no existe.
     */
    public Ventas getVentaPorId(int id) {
        return ventaRepo.buscarPorId(id);
    }

}
