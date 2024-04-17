import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completar() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return descripcion + " - Completada: " + completada;
    }
}

public class GestionTareas {
    private List<Tarea> tareas;

    public GestionTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(String descripcion) {
        tareas.add(new Tarea(descripcion));
    }

    public void marcarTareaComoCompletada(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.get(indice).completar();
        } else {
            System.out.println("Índice de tarea inválido.");
        }
    }

    public List<Tarea> filtrarTareas(Predicate<Tarea> condicion) {
        return tareas.stream()
                .filter(condicion)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        GestionTareas gestionTareas = new GestionTareas();

        gestionTareas.agregarTarea("Hacer la compra");
        gestionTareas.agregarTarea("Llamar al cliente");
        gestionTareas.agregarTarea("Preparar la presentación");

        gestionTareas.marcarTareaComoCompletada(0);

        // Filtrar tareas completadas
        List<Tarea> tareasCompletadas = gestionTareas.filtrarTareas(Tarea::isCompletada);
        System.out.println("Tareas completadas:");
        tareasCompletadas.forEach(System.out::println);
    }
}

/**
 * En este ejemplo, hemos utilizado programación funcional en Java haciendo uso de las características proporcionadas por Java 8 y posteriores, 
 * como expresiones lambda y streams. La clase Tarea representa una tarea con una descripción y un estado de completitud. 
 * La clase GestionTareas proporciona métodos para agregar tareas, marcar tareas como completadas y filtrar tareas según ciertas condiciones, 
 * utilizando expresiones lambda como predicados en el método filtrarTareas.
 */