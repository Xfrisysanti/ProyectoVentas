package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Repositorios.RepositorioProducto;
import java.util.List;

/**
 * Controlador que gestiona las operaciones sobre productos en el sistema.
 * Se encarga de agregar, eliminar, buscar, editar y obtener productos en el repositorio.
 */

public class ControladorProducto {
    public final RepositorioProducto repo=new RepositorioProducto();
    /**
     * Agrega un nuevo producto al repositorio.
     * @param producto El producto a agregar.
     */
    
    public void agregarProducto(Producto producto) {
          // Llama al repositorio para guardar el producto.
          repo.guardar(producto);
    }
    
    /**
     * Elimina un producto del repositorio.
     * @param id Del producto a eliminar.
     */
    public void eliminarProducto(int id) {
        repo.eliminar(id);  // Llama al repositorio para eliminar el producto.
    }

    /**
     * Obtiene todos los productos almacenados en el repositorio.
     * @return Una lista de todos los productos.
     */
    public List<Producto> obtenerTodos() {
        return repo.listarTodos();  // Devuelve todos los productos del repositorio.
    }

    /**
     * Obtiene el número total de productos en el repositorio.
     * @return El número total de productos.
     */
    

    /**
     * Busca un producto en el repositorio por su ID.
     * @param id El nombre del producto a buscar.
     * @return El producto encontrado
     */
    public Producto buscarProducto(int id) {
        return repo.buscarPorId(id);
    }
    public boolean editarProducto(int id, String nuevoNombre, double nuevoPrecio, int unidades,double peso) {
        Producto producto = repo.buscarPorId(id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            // permite editar peso o unidades
            if(repo.buscarPorId(id).getPeso()!=-1){
                producto.setPeso(peso);
            }
            else{
                producto.setUnidades(unidades);
            }
            return repo.editar(producto);
        }
        return false;
    }
 
    

    
}
