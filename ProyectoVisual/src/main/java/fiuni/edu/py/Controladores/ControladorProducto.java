package fiuni.edu.py.Controladores;

import fiuni.edu.py.Modelo.Producto;
import fiuni.edu.py.Repositorios.RepositorioProducto;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.List;

/**
 * Controlador que gestiona las operaciones sobre productos en el sistema. Se
 * encarga de agregar, eliminar, buscar, editar y obtener productos en el
 * repositorio.
 *
 * @author luisf
 */
public class ControladorProducto {

    /**
     * Repositorio que almacena los productos.
     */
    public final RepositorioProducto repo = new RepositorioProducto();

    /**
     * Agrega un nuevo producto al repositorio.
     *
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        // Llama al repositorio para guardar el producto.
        repo.guardar(producto);
    }

    /**
     * Elimina un producto del repositorio.
     *
     * @param id Del producto a eliminar.
     */
    public void eliminarProducto(int id) {
        repo.eliminar(id);  // Llama al repositorio para eliminar el producto.
    }

    /**
     * Obtiene todos los productos almacenados en el repositorio.
     *
     * @return Una lista de todos los productos.
     */
    public List<Producto> obtenerTodos() {
        return repo.listarTodos();  // Devuelve todos los productos del repositorio.
    }

    /**
     * Obtiene un nuevo ID generado para un producto.
     *
     * @return Un ID único para un nuevo producto.
     */
    public int conseguirId() {
        return repo.conseguirID();
    }

    /**
     * Busca un producto en el repositorio por su ID.
     *
     * @param id El nombre del producto a buscar.
     * @return El producto encontrado
     */
    public Producto buscarProducto(int id) {
        return repo.buscarPorId(id);
    }

    /**
     * Verifica si existe un producto con el nombre especificado (ignorando
     * espacios y mayúsculas).
     *
     * @param nombre El nombre a verificar.
     * @return true si existe un producto con ese nombre, false en caso
     * contrario.
     */
    public boolean existeProductosConEsteNombre(String nombre) {
        for (Producto p : repo.listarTodos()) {
            if (p.getNombre().trim().toLowerCase().replaceAll(" ", "").equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca el ID de un producto según su nombre (ignorando espacios y
     * mayúsculas).
     *
     * @param nombre El nombre del producto a buscar.
     * @return El ID del producto si se encuentra, -1 si no existe.
     */
    public int buscarProductoPorNombre(String nombre) {
        for (Producto p : repo.listarTodos()) {
            if (p.getNombre().trim().toLowerCase().replaceAll(" ", "").equalsIgnoreCase(nombre)) {
                return p.getIdProducto();
            }
        }
        return -1;
    }

    /**
     * Edita los atributos de un producto.
     *
     * @param id ID del producto a editar.
     * @param nuevoNombre Nuevo nombre del producto.
     * @param nuevoPrecio Nuevo precio del producto.
     * @param stock Nuevo valor del stock (peso o unidades).
     * @param pesoOunidad true si el stock se representa en peso, false si se
     * representa en unidades.
     * @return true si la edición fue exitosa, false si no se encontró el
     * producto.
     */
    public boolean editarProducto(int id, String nuevoNombre, double nuevoPrecio, String stock, boolean pesoOunidad) {
        Producto producto = repo.buscarPorId(id);
        if (producto != null) {
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            // permite editar peso o unidades
            //SI ES TRUE SE EDITA POR PESO, SI ES FALSE POR UNIDAD
            if (pesoOunidad) {
                producto.setPeso(parseDouble(stock));
            } else {
                producto.setUnidades(parseInt(stock));
            }
            return repo.editar(producto);
        }
        return false;
    }

    /**
     * Obtiene el nombre de un producto dado su ID.
     *
     * @param id ID del producto.
     * @return El nombre del producto.
     */
    public String getNombre(int id) {
        return repo.buscarPorId(id).getNombre();
    }

    /**
     * Obtiene el precio de un producto dado su ID.
     *
     * @param id ID del producto.
     * @return El precio del producto.
     */
    public double getPrecio(int id) {
        return repo.buscarPorId(id).getPrecio();
    }

    /**
     * Obtiene el peso del producto dado su ID.
     *
     * @param id ID del producto.
     * @return El peso del producto.
     */
    public double getPeso(int id) {
        return repo.buscarPorId(id).getPeso();
    }

    /**
     * Obtiene la cantidad de unidades disponibles de un producto dado su ID.
     *
     * @param id ID del producto.
     * @return Las unidades disponibles.
     */
    public int getUnidades(int id) {
        return repo.buscarPorId(id).getUnidades();
    }

    /**
     * Establece un nuevo valor de unidades para un producto.
     *
     * @param id ID del producto.
     * @param unidades Nuevas unidades a asignar.
     */
    public void setUnidades(int id, int unidades) {
    Producto producto = repo.buscarPorId(id);
    producto.setUnidades(unidades);
    repo.editar(producto);
}

    /**
     * Establece un nuevo valor de peso para un producto.
     *
     * @param id ID del producto.
     * @param peso Nuevo peso a asignar.
     */
    public void setPeso(int id, double peso) {
    Producto producto = repo.buscarPorId(id);
    producto.setPeso(peso);
    repo.editar(producto);
}

}
