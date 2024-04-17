import java.util.ArrayList;
import java.util.List;

class Libro {
    private String titulo;
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void prestar() {
        prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " - Prestado: " + prestado;
    }
}

class Biblioteca {
    private List<Libro> inventario;

    public Biblioteca() {
        this.inventario = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public void prestarLibro(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            Libro libro = inventario.get(indice);
            if (!libro.estaPrestado()) {
                libro.prestar();
                System.out.println("Libro prestado: " + libro.getTitulo());
            } else {
                System.out.println("El libro ya está prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }

    public void devolverLibro(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            Libro libro = inventario.get(indice);
            if (libro.estaPrestado()) {
                libro.devolver();
                System.out.println("Libro devuelto: " + libro.getTitulo());
            } else {
                System.out.println("El libro no estaba prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la biblioteca:");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i+1) + ". " + inventario.get(i));
        }
    }
}

public class SistemaGestionBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros al inventario
        biblioteca.agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien"));
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        biblioteca.agregarLibro(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling"));

        // Prestar un libro
        biblioteca.prestarLibro(0);

        // Devolver un libro
        biblioteca.devolverLibro(1);

        // Mostrar inventario
        biblioteca.mostrarInventario();
    }
}

/**
 * En esta solución, la clase Libro modela un libro con atributos como título, autor y estado de préstamo. 
 * La clase Biblioteca representa la biblioteca con métodos para agregar libros al inventario, prestar libros, 
 * devolver libros y mostrar el inventario. La programación orientada a objetos se refleja en la encapsulación de datos y 
 * el comportamiento asociado a los objetos Libro y Biblioteca, así como en la interacción entre ellos.
 */
