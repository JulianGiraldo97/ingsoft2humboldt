import java.util.ArrayList;
import java.util.List;

// Componente abstracto que define la interfaz común para hojas y contenedores.
interface Componente {
    void dibujar();
}

// Clase hoja que representa un objeto individual.
class Hoja implements Componente {
    private String nombre;

    public Hoja(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando hoja: " + nombre);
    }
}

// Clase contenedor que puede contener hojas y otros contenedores.
class Contenedor implements Componente {
    private List<Componente> componentes = new ArrayList<>();

    public void agregar(Componente componente) {
        componentes.add(componente);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando contenedor:");
        for (Componente componente : componentes) {
            componente.dibujar();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear hojas
        Hoja hoja1 = new Hoja("Hoja 1");
        Hoja hoja2 = new Hoja("Hoja 2");

        // Crear contenedor y agregar hojas y otro contenedor
        Contenedor contenedor = new Contenedor();
        contenedor.agregar(hoja1);
        contenedor.agregar(hoja2);

        Hoja hoja3 = new Hoja("Hoja 3");
        Hoja hoja4 = new Hoja("Hoja 4");

        Contenedor contenedor2 = new Contenedor();
        contenedor2.agregar(hoja3);
        contenedor2.agregar(hoja4);

        contenedor.agregar(contenedor2);

        // Dibujar la estructura
        contenedor.dibujar();
    }
}
