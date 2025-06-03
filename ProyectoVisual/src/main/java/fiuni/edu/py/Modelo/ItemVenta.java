/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Modelo;

/**
 * Representa un item dentro de la venta, se asocia a un producto y a una
 * cantidad determinada de este
 * 
 * @author luisf
 */
public class ItemVenta {

    /** Identificador del producto asociado a este ítem de venta */
    private final int idProducto;

    /** Cantidad del producto que se está vendiendo */
    private  int cantidadUnidad;
    private  double cantidadPeso;
    /**
     * Crea un nuevo ítem de venta con el producto y la cantidad especificados.
     * 
     * @param productoId Identificador del producto
     * @param cantidad Cantidad del producto en la venta
     */
    public ItemVenta(int productoId, int cantidad) {
        this.idProducto = productoId;
        this.cantidadUnidad = cantidad;
    }
    public ItemVenta(int productoId, double cantidad) {
        this.idProducto = productoId;
        this.cantidadPeso = cantidad;
    }
    /**
     * Obtiene el identificador del producto asociado a este ítem de venta.
     * 
     * @return Identificador del producto
     */
    public int getProductoId() {
        return idProducto;
    }

    /**
     * Obtiene la cantidad del producto que se está vendiendo.
     * 
     * @return Cantidad del producto
     */
    public int getCantidadUnidad() {
        return cantidadUnidad;
    }
    public double getCantidadPeso() {
        return cantidadPeso;
    }
}
