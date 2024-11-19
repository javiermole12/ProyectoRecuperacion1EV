import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Cargar los datos iniciales


        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear nueva sede");
            System.out.println("2. Introducir coche en una sede");
            System.out.println("3. Vender coche");
            System.out.println("4. Buscar coches por marca");
            System.out.println("5. Buscar coches por modelo");
            System.out.println("6. Mostrar listado de coches por concesionario");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea
        }
    }
}