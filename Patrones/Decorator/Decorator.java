// Interfaz Componente que representa la clase base (componente) que queremos decorar.
interface Cafe {
    String getDescription();
    double cost();
}

// Clase concreta que implementa la interfaz Componente.
class CafeSimple implements Cafe {
    @Override
    public String getDescription() {
        return "Café Simple";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

// Clase abstracta Decorador que implementa la interfaz Componente y contiene una referencia al componente base.
abstract class CafeDecorator implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorator(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public String getDescription() {
        return cafeDecorado.getDescription();
    }

    @Override
    public double cost() {
        return cafeDecorado.cost();
    }
}

// Clases concretas de Decorador que agregan ingredientes al café.
class LecheDecorator extends CafeDecorator {
    public LecheDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String getDescription() {
        return cafeDecorado.getDescription() + ", Leche";
    }

    @Override
    public double cost() {
        return cafeDecorado.cost() + 0.5;
    }
}

class CanelaDecorator extends CafeDecorator {
    public CanelaDecorator(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public String getDescription() {
        return cafeDecorado.getDescription() + ", Canela";
    }

    @Override
    public double cost() {
        return cafeDecorado.cost() + 0.2;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un café simple
        Cafe cafeSimple = new CafeSimple();
        System.out.println("Café Simple: " + cafeSimple.getDescription() + ", Costo: $" + cafeSimple.cost());

        // Decorar el café con leche
        Cafe cafeConLeche = new LecheDecorator(cafeSimple);
        System.out.println("Café con Leche: " + cafeConLeche.getDescription() + ", Costo: $" + cafeConLeche.cost());

        // Decorar el café con canela
        Cafe cafeConLecheYCanela = new CanelaDecorator(cafeConLeche);
        System.out.println("Café con Leche y Canela: " + cafeConLecheYCanela.getDescription() + ", Costo: $" + cafeConLecheYCanela.cost());
    }
}
