public class ProgramacionImperativa {

    public static void main(String[] args) {
        int sumaTotal = 0;
        int limite = 10;

        for (int i = 1; i <= limite; i++) {
            if (i % 2 == 0) {
                sumaTotal += i;
            }
        }

        System.out.println("Suma total de números pares: " + sumaTotal);
    }
}
