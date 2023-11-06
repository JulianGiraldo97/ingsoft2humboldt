import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Clase que representa una colección de números enteros.
class ColeccionNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public void agregarNumero(int numero) {
        numeros.add(numero);
    }

    public Iterator<Integer> crearIterador() {
        return new IteradorNumeros(numeros);
    }
}

// Interfaz Iterator que define los métodos para recorrer una colección.
interface IteratorNumeros {
    boolean hasNext();
    Integer next();
}

// Clase concreta que implementa el Iterator para la colección de números.
class IteradorNumeros implements IteratorNumeros {
    private List<Integer> numeros;
    private int indice = 0;

    public IteradorNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    @Override
    public boolean hasNext() {
        return indice < numeros.size();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return numeros.get(indice++);
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ColeccionNumeros coleccion = new ColeccionNumeros();
        coleccion.agregarNumero(1);
        coleccion.agregarNumero(2);
        coleccion.agregarNumero(3);

        // Obtener un Iterator para la colección de números
        IteratorNumeros iterator = coleccion.crearIterador();

        // Recorrer la colección e imprimir los números
        while (iterator.hasNext()) {
            System.out.println("Número: " + iterator.next());
        }
    }
}
