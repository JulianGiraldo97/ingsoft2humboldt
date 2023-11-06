import java.util.ArrayList;
import java.util.List;

// Interfaz Observador que define el método de actualización.
interface Observador {
    void actualizar(String mensaje);
}

// Clase Concreta de Observador
class Usuario implements Observador {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(nombre + " ha recibido un mensaje: " + mensaje);
    }
}

// Sujeto (también conocido como "Observable") que mantiene una lista de observadores y notifica los cambios.
class RedSocial {
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void publicarMensaje(String mensaje) {
        System.out.println("Mensaje publicado: " + mensaje);
        notificarObservadores(mensaje);
    }

    private void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un sujeto (Red Social)
        RedSocial redSocial = new RedSocial();

        // Crear observadores (Usuarios)
        Observador usuario1 = new Usuario("Usuario1");
        Observador usuario2 = new Usuario("Usuario2");

        // Agregar observadores a la lista de seguidores
        redSocial.agregarObservador(usuario1);
        redSocial.agregarObservador(usuario2);

        // Publicar un mensaje en la red social
        redSocial.publicarMensaje("¡Hola a todos!");

        // Eliminar un observador (Usuario2)
        redSocial.eliminarObservador(usuario2);

        // Publicar otro mensaje en la red social
        redSocial.publicarMensaje("¡Adiós!");

        // Usuario2 ya no recibe notificaciones porque fue eliminado de los observadores.
    }
}
