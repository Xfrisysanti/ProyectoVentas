
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Modelo.Ventas;
import fiuni.edu.py.Modelo.ItemVenta;
import fiuni.edu.py.Repositorios.RepositorioProducto;
import fiuni.edu.py.Repositorios.RepositorioVentasEliminadas;

import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con las
 * ventas que son eliminadas, incluyendo el registro, Se comunica con los repositorios de ventas y productos.
 *
 * @author luisf
 */
public class ControladorVentasEliminadas {

    public ControladorVentasEliminadas() {
    }
    /**Repositorio de ventas eliminadas*/
    private final RepositorioVentasEliminadas ventaRepo = new RepositorioVentasEliminadas();
    /**Repositorio de productos*/
    private final RepositorioProducto productoRepo = new RepositorioProducto();
    
    /**
     * Guarda una venta eliminada en el repositorio.
     *
     * @param venta que se desea guardar.
     */
    public void registrarVenta(Ventas venta) {
        ventaRepo.agregarVentaEliminada(venta);
    }

    /**
     * Devuelve una lista con todas las ventas eliminadas registradas.
     *
     * @return Lista de ventas.
     */
    public List<Ventas> listarVentas() {
        return ventaRepo.listarTodas();
    }


    /**
     * Calcula el total de una venta eliminada en base a los productos y sus cantidades.
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


    /**
     * Busca un producto por su identificador.
     *
     * @param id Identificador del producto.
     * @return El producto correspondiente o {@code null} si no se encuentra.
     */
    public Producto getProductoPorId(int id) {
        return productoRepo.buscarPorId(id);
    }


}
