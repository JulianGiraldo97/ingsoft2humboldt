public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private int edad;

    // Constructor de la clase Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre de la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener la edad de la persona
    public int getEdad() {
        return edad;
    }

    // Método para establecer la edad de la persona
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método para mostrar información de la persona
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
    }

    public static void main(String[] args) {
        // Crear objetos de la clase Persona
        Persona persona1 = new Persona("Juan", 30);
        Persona persona2 = new Persona("Ana", 25);

        // Acceder a los métodos y atributos de los objetos
        persona1.mostrarInformacion();
        persona2.mostrarInformacion();
    }
}
