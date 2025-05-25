
package fiuni.edu.py.Modelo;

public class Producto {
    private double precio;
    private String nombre;
    private double peso;
    private int unidades;

    public Producto(double precio, String nombre, int unidades) {
        this.peso = -1;
        this.unidades = unidades;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(double precio, String nombre, double peso) {
        this.peso = peso;
        this.unidades = -1;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return this.peso != (double)-1.0F ? "Nombre=" + this.nombre + " -- Peso=" + this.peso + " kg -- Precio por kilo=" + this.precio : "Nombre=" + this.nombre + " -- Unidades=" + this.unidades + " -- Precio por unidad=" + this.precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Producto producto = (Producto)o;
            return this.nombre.equalsIgnoreCase(producto.nombre);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.nombre.toLowerCase().hashCode();
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPeso() {
        return this.peso;
    }

    public int getUnidades() {
        return this.unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}

