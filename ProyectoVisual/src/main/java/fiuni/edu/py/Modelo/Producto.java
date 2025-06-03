package fiuni.edu.py.Modelo;

import java.io.Serializable;

/**
 * Clase que representa un producto dentro del sistema. Puede ser un producto
 * vendido por unidades o por peso. Implementa la interfaz Serializable para
 * permitir su almacenamiento en archivos binarios.
 *
 * @author santi
 */
public class Producto implements Serializable {

    /**
     * Identificador único del producto.
     */
    private int id;
    /**
     * Precio del producto (por unidad o por kilo).
     */
    private double precio;
    /**
     * Nombre del producto.
     */
    private String nombre;
    /**
     * Peso del producto si es vendido por kilo. Si no aplica, su valor será -1.
     */
    private double peso;
    /**
     * Cantidad de unidades disponibles si es vendido por unidad. Si no aplica,
     * su valor será -1.
     */
    private int unidades;
    /**
     * Número de versión para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor para productos vendidos por unidad.
     *
     * @param precio Precio por unidad.
     * @param nombre Nombre del producto.
     * @param unidades Cantidad de unidades disponibles.
     */
    public Producto(double precio, String nombre, int unidades) {
        this.id = id;
        this.peso = -1;
        this.unidades = unidades;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Constructor para productos vendidos por peso.
     *
     * @param precio Precio por kilo.
     * @param nombre Nombre del producto.
     * @param peso Peso del producto.
     */
    public Producto(double precio, String nombre, double peso) {
        this.id = id;
        this.peso = peso;
        this.unidades = -1;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Devuelve una representación en texto del producto, indicando si se vende
     * por peso o por unidad.
     *
     * @return Una cadena con el nombre, cantidad y precio del producto.
     */
    @Override
    public String toString() {
        return this.peso != (double) -1.0F ? "Nombre=" + this.nombre + " -- Peso=" + this.peso + " kg -- Precio por kilo=" + this.precio : "Nombre=" + this.nombre + " -- Unidades=" + this.unidades + " -- Precio por unidad=" + this.precio;
    }

    /**
     * Compara este producto con otro para determinar si son iguales según el
     * nombre (ignorando mayúsculas).
     *
     * @param o Objeto a comparar.
     * @return true si los productos tienen el mismo nombre, false en caso
     * contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Producto producto = (Producto) o;
            return this.nombre.equalsIgnoreCase(producto.nombre);
        } else {
            return false;
        }
    }

    /**
     * Calcula el código hash del producto basado en su nombre en minúsculas.
     *
     * @return El código hash del producto.
     */
    @Override
    public int hashCode() {
        return this.nombre.toLowerCase().hashCode();
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getIdProducto() {
        return id;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el peso del producto (si aplica).
     *
     * @return El peso del producto o -1 si no se vende por peso.
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Obtiene las unidades disponibles del producto (si aplica).
     *
     * @return La cantidad de unidades o -1 si no se vende por unidad.
     */
    public int getUnidades() {
        return this.unidades;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id El nuevo ID del producto.
     */
    public void setIdProducto(int id) {
        this.id = id;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Establece el peso del producto.
     *
     * @param peso El nuevo peso del producto.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Establece la cantidad de unidades del producto.
     *
     * @param unidades La nueva cantidad de unidades.
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
