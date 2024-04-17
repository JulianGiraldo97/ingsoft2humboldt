import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Integer> inventario;

    public Inventario() {
        this.inventario = new HashMap<>();
    }

    // Método para agregar un nuevo producto al inventario
    public void agregarProducto(String nombre, int cantidad) {
        if (inventario.containsKey(nombre)) {
            System.out.println("El producto ya existe en el inventario.");
            return;
        }
        inventario.put(nombre, cantidad);
        System.out.println("Producto agregado al inventario: " + nombre + " - Cantidad: " + cantidad);
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(String nombre) {
        if (!inventario.containsKey(nombre)) {
            System.out.println("El producto no existe en el inventario.");
            return;
        }
        inventario.remove(nombre);
        System.out.println("Producto eliminado del inventario: " + nombre);
    }

    // Método para actualizar la cantidad de un producto en el inventario
    public void actualizarCantidad(String nombre, int cantidad) {
        if (!inventario.containsKey(nombre)) {
            System.out.println("El producto no existe en el inventario.");
            return;
        }
        inventario.put(nombre, cantidad);
        System.out.println("Cantidad actualizada para el producto " + nombre + ": " + cantidad);
    }

    // Método para mostrar el inventario completo
    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " - Cantidad: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto("Camiseta", 50);
        inventario.agregarProducto("Pantalón", 30);
        inventario.mostrarInventario();

        inventario.actualizarCantidad("Camiseta", 40);
        inventario.mostrarInventario();

        inventario.eliminarProducto("Pantalón");
        inventario.mostrarInventario();
    }
}


/**
 * Este ejemplo utiliza programación imperativa para modelar el sistema de gestión de inventario. 
 * Las operaciones se realizan directamente sobre el inventario utilizando métodos como agregarProducto, 
 * eliminarProducto, actualizarCantidad y mostrarInventario. 
 * La clase Inventario utiliza un HashMap para almacenar los productos y sus cantidades.
 */