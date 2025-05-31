/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Modelo.Ventas;
import fiuni.edu.py.Modelo.ItemVenta;
import fiuni.edu.py.Repositorios.RepositorioClientes;
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

    private final RepositorioVentas ventaRepo;
    private final RepositorioClientes clienteRepo;
    private final RepositorioProducto productoRepo;

    /**
     * Constructor del controlador de ventas.
     *
     * @param ventaRepo Repositorio para gestionar las ventas.
     * @param clienteRepo Repositorio para verificar existencia de clientes.
     * @param productoRepo Repositorio para verificar existencia y stock de
     * productos.
     */
    public ControladorVentas(RepositorioVentas ventaRepo, RepositorioClientes clienteRepo, RepositorioProducto productoRepo) {
        this.ventaRepo = ventaRepo;
        this.clienteRepo = clienteRepo;
        this.productoRepo = productoRepo;
    }

    
    
    public void registrarVenta(Ventas venta){
        ventaRepo.guardar(venta);
    }
    
    /*public Ventas registrarVenta(int clienteId, List<ItemVenta> items, LocalDate fecha) {
        if (clienteRepo.buscarPorIdentificacion(clienteId) == null) {
            System.out.println("Cliente no encontrado.");
            return null;
        }
           /*
        for (ItemVenta item : items) {
            Producto producto = productoRepo.buscarPorId(item.getProductoId());
            if (producto == null) {
                System.out.printf("Producto con ID %d no encontrado.\n", item.getProductoId());
                return null;
            }
            if (producto.getStock() < item.getCantidad()) {
                System.out.printf("Stock insuficiente para el producto '%s'.\n", producto.getNombre());
                return null;
            }
        }

        for (ItemVenta item : items) {
            Producto producto = productoRepo.buscarPorId(item.getProductoId());
            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepo.editar(producto);
        }
        
           
        Ventas venta = new Ventas(clienteId, items, fecha);
        ventaRepo.guardar(venta);
        System.out.println("Venta registrada con exito.");
        System.out.println("ID de Venta: " + venta.getIdVenta());
        return venta;
    }*/

    /**
     * Devuelve una lista con todas las ventas registradas.
     *
     * @return Lista de ventas.
     */
    public List<Ventas> listarVentas() {
        return ventaRepo.listarTodos();
    }
    
    public void eliminarVenta(int id){
        ventaRepo.eliminar(id);
    }
    /**
     * Elimina una venta por su identificador. Muestra un mensaje indicando el
     * resultado.
     *
     * @param ventaId Identificador de la venta a eliminar.
     */
    /*public void eliminarVenta(int ventaId) {
        Ventas ventaEliminada = ventaRepo.eliminar(ventaId);
        if (ventaEliminada != null) {
            System.out.println("Venta eliminada.");
        } else {
            System.out.println("No se encontró la venta.");
        }
    }
    */
    
    
    /**
     * Calcula el total de una venta dada la lista de ítems. Omite productos no
     * encontrados.
     *
     * @param items Lista de ítems de la venta.
     * @return Total calculado de la venta.
     */
    public double calcularTotalVenta(List<ItemVenta> items) {
        double total = 0.0;

        for (ItemVenta item : items) {
            Producto producto = productoRepo.buscarPorId(item.getProductoId());

            if (producto != null) {
                double precioUnitario = producto.getPrecio();
                int cantidad = item.getCantidad();
                total += precioUnitario * cantidad;
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
