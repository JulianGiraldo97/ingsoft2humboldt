// 1. Define una interfaz para los productos (enemigos)
interface Enemigo {
    void atacar();
}

// 2. Crea clases concretas que implementen la interfaz
class EnemigoNormal implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("Enemigo Normal ataca.");
    }
}

class EnemigoJefe implements Enemigo {
    @Override
    public void atacar() {
        System.out.println("Enemigo Jefe ataca.");
    }
}

// 3. Crea la interfaz de la fábrica
interface FabricaEnemigos {
    Enemigo crearEnemigo();
}

// 4. Implementa fábricas concretas
class FabricaEnemigoNormal implements FabricaEnemigos {
    @Override
    public Enemigo crearEnemigo() {
        return new EnemigoNormal();
    }
}

class FabricaEnemigoJefe implements FabricaEnemigos {
    @Override
    public Enemigo crearEnemigo() {
        return new EnemigoJefe();
    }
}

public class Main {
    public static void main(String[] args) {
        // 5. Usa la fábrica para crear enemigos
        FabricaEnemigos fabricaNormal = new FabricaEnemigoNormal();
        Enemigo enemigoNormal = fabricaNormal.crearEnemigo();
        enemigoNormal.atacar();

        FabricaEnemigos fabricaJefe = new FabricaEnemigoJefe();
        Enemigo enemigoJefe = fabricaJefe.crearEnemigo();
        enemigoJefe.atacar();
    }
}
