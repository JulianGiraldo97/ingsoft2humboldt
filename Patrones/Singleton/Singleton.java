public class Singleton {

    // 1. Private static variable que almacena la única instancia de la clase.
    private static Singleton instance;

    // 2. Constructor privado para evitar la creación de instancias desde fuera de la clase.
    private Singleton() {
        // Inicialización de la instancia, si es necesario.
    }

    // 3. Método público para obtener la única instancia de la clase.
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Otros métodos y datos de la clase Singleton
    public void someMethod() {
        System.out.println("Método de la instancia Singleton.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Intentamos crear dos instancias de Singleton
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Verificamos si son la misma instancia
        if (singleton1 == singleton2) {
            System.out.println("Las dos instancias son la misma instancia Singleton.");
        } else {
            System.out.println("Las dos instancias no son la misma instancia Singleton.");
        }

        // Usamos la instancia Singleton
        singleton1.someMethod();
    }
}
