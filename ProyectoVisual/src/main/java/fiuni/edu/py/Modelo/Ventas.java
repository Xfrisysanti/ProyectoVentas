
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiuni.edu.py.Modelo;
import java.time.LocalDate;
import java.util.List;
/**
 * Representa una venta realizada a un cliente determinado, desde la 
 * perspectiva del vendedor, incluyendo los productos vendidos, la fecha de
 * venta y el total de la venta.
 * 
 * @author luisf
 */

public class Ventas {

    /** Identificador único de la venta */
    private int idVenta = 0;

    /** Identificador del cliente que realizó la compra */
    private int idCliente = 0;

    /** Lista de ítems vendidos en esta venta */
    private List<ItemVenta> items;

    /** Fecha en la que se realizó la venta */
    private LocalDate fechaVenta = LocalDate.now();

    /** Monto total de la venta */
    private int total = 0;

    /**
     * Constructor que crea una venta con los datos especificados.
     * 
     * @param cliente Identificador del cliente que realiza la compra
     * @param items Lista de productos vendidos
     * @param fecha Fecha en la que se realizó la venta
     */
    public Ventas(int cliente, List<ItemVenta> items, LocalDate fecha) {
        this.idCliente = cliente;
        this.items = items;
        this.fechaVenta = fecha;
    }

    /**
     * Constructor por defecto que inicializa la venta con valores predeterminados.
     */
    public Ventas() {
        this.idCliente = 0;
        this.items = null;
        this.fechaVenta = LocalDate.now();
    }

    /**
     * Establece el identificador único de la venta.
     * 
     * @param id Identificador de la venta
     */
    public void setIdVenta(int id) {
        this.idVenta = id;
    }

    /**
     * Obtiene el identificador de la venta.
     * 
     * @return Identificador de la venta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el identificador del cliente que realiza la compra.
     * 
     * @param cliente Identificador del cliente
     */
    public void setIdCliente(int cliente) {
        this.idCliente = cliente;
    }

    /**
     * Obtiene el identificador del cliente que realizó la compra.
     * 
     * @return Identificador del cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece la lista de productos vendidos en la venta.
     * 
     * @param items Lista de ítems de venta
     */
    public void setItems(List<ItemVenta> items) {
        this.items = items;
    }

    /**
     * Obtiene la lista de productos vendidos en la venta.
     * 
     * @return Lista de ítems de venta
     */
    public List<ItemVenta> getItems() {
        return items;
    }

    /**
     * Obtiene la fecha en la que se realizó la venta.
     * 
     * @return Fecha de la venta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Obtiene el monto total de la venta.
     * 
     * @return Total de la venta
     */


    /**
     * Establece el monto total de la venta.
     * 
     * @param total Nuevo total de la venta
     */
    public void setTotal(int total) {
        this.total = total;
    }
}
