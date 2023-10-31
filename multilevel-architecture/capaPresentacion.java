import java.util.Scanner;

public class PresentationLayer {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nombre del empleado: ");
                    String name = scanner.next();
                    System.out.print("Salario del empleado: ");
                    double salary = scanner.nextDouble();
                    Employee employee = new Employee(name, salary);
                    employeeService.addEmployee(employee);
                    break;
                case 2:
                    for (Employee emp : employeeService.getAllEmployees()) {
                        System.out.println("Nombre: " + emp.getName() + ", Salario: " + emp.getSalary());
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");    
            }
        }
    }
}
