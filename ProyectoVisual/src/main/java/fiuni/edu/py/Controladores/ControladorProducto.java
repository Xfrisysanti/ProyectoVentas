package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Repositorios.RepositorioProducto;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
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
    public int conseguirId(){
        return repo.conseguirID();
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
    public boolean editarProducto(int id, String nuevoNombre, double nuevoPrecio, String stock, boolean pesoOunidad) {
        Producto producto = repo.buscarPorId(id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            // permite editar peso o unidades
            //SI ES TRUE SE EDITA POR PESO, SI ES FALSE POR UNIDAD
            if(pesoOunidad){
                producto.setPeso(parseDouble(stock));
            }
            else{
                producto.setUnidades(parseInt(stock));
            }
            return repo.editar(producto);
        }
        return false;
    }
    public String getNombre(int id){
        return repo.buscarPorId(id).getNombre();
    }
    public double getPrecio(int id){
        return repo.buscarPorId(id).getPrecio();
    }
    public double getPeso(int id){
        return repo.buscarPorId(id).getPeso();
    }
    public int getUnidades(int id){
        return repo.buscarPorId(id).getUnidades();
    }

   
    
    
}
