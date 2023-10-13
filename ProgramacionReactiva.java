import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ProgramacionReactivaEjemplo {

    public static void main(String[] args) {
        // Crear un flujo de números del 1 al 10
        Flux<Integer> numeros = Flux.range(1, 10);

        // Aplicar una transformación (multiplicar por 2) de manera reactiva
        numeros
            .map(numero -> numero * 2)
            .publishOn(Schedulers.parallel())  // Ejecutar en un subproceso paralelo
            .subscribe(
                numero -> System.out.println("Número transformado: " + numero),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Transformación completada")
            );

        // Esperar un momento para que la ejecución asíncrona termine
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
