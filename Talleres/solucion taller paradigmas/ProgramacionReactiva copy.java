import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Paquete {
    private String id;
    private Estado estado;
    private String ubicacion;

    public Paquete(String id) {
        this.id = id;
        this.estado = Estado.EN_TRANSITO;
        this.ubicacion = "Almacén";
    }

    public String getId() {
        return id;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void actualizarEstado(Estado estado, String ubicacion) {
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Paquete " + id + " - Estado: " + estado + " - Ubicación: " + ubicacion;
    }
}

enum Estado {
    EN_ALMACEN,
    EN_TRANSITO,
    ENTREGADO
}

public class SeguimientoPaquetes {
    private Map<String, Paquete> paquetes;

    public SeguimientoPaquetes() {
        this.paquetes = new HashMap<>();
    }

    public Mono<Paquete> enviarPaquete(String id) {
        Paquete paquete = new Paquete(id);
        paquetes.put(id, paquete);
        return Mono.just(paquete);
    }

    public Flux<Paquete> rastrearPaquete(String id) {
        return Flux.interval(Duration.ofSeconds(2))
                .map(seq -> {
                    Paquete paquete = paquetes.get(id);
                    if (paquete != null) {
                        actualizarEstadoPaquete(paquete);
                    }
                    return paquete;
                });
    }

    private void actualizarEstadoPaquete(Paquete paquete) {
        Random random = new Random();
        int randomNum = random.nextInt(3);
        Estado nuevoEstado = Estado.values()[randomNum];
        paquete.actualizarEstado(nuevoEstado, generarUbicacionAleatoria());
    }

    private String generarUbicacionAleatoria() {
        String[] ubicaciones = {"Almacén", "Centro de distribución", "En tránsito", "Oficina de entrega"};
        Random random = new Random();
        int randomIndex = random.nextInt(ubicaciones.length);
        return ubicaciones[randomIndex];
    }

    public static void main(String[] args) {
        SeguimientoPaquetes seguimientoPaquetes = new SeguimientoPaquetes();

        seguimientoPaquetes.enviarPaquete("P001").subscribe(paquete -> {
            System.out.println("Paquete enviado: " + paquete);
        });

        seguimientoPaquetes.rastrearPaquete("P001").subscribe(paquete -> {
            System.out.println("Actualización de estado: " + paquete);
        });
    }
}

/**
 * En esta solución, la clase Paquete representa un paquete con atributos como ID, estado y ubicación. 
 * La clase SeguimientoPaquetes proporciona métodos para enviar un nuevo paquete y rastrear un paquete existente. 
 * La función rastrearPaquete devuelve un flujo (Flux) que emite actualizaciones de estado del paquete en 
 * intervalos regulares simulando cambios de estado y ubicación. La programación reactiva se refleja en el 
 * uso de los tipos Mono y Flux de Reactor, que permiten manejar flujos de datos asíncronos y reactuar a los eventos que se producen en tiempo real.






 */