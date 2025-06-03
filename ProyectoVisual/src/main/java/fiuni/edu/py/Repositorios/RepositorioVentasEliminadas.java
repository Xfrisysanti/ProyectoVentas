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
 *
 * @author santi
 */
public class RepositorioVentasEliminadas {
    private static final String ARCHIVO = "ventasEliminadas.dat";
    RepositorioProducto productoRepo= new RepositorioProducto();
   private static final Map<Integer, Ventas> ventasEliminadas = new HashMap<>();
   private static int idActual=1000;
   
   private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(ventasEliminadas);
            out.writeInt(idActual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar datos desde el archivo binario al iniciar el repositorio
    private void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Map<Integer, Ventas> datosCargados = (Map<Integer, Ventas>) in.readObject();
            ventasEliminadas.putAll(datosCargados);
            idActual = in.readInt(); // Recuperar el último ID usado
        } catch (IOException | ClassNotFoundException e) {
            // Si hay error, el archivo puede no existir aún, entonces mantenemos el mapa vacío
        }
    }
   public void agregarEventaEliminada(Ventas ventaEliminada){  
        ventasEliminadas.put(idActual, ventaEliminada);
        idActual++;
         guardarDatos();
   }
   
   public List<Ventas> listarTodas() {
        return new ArrayList<>(ventasEliminadas.values());
    }
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
