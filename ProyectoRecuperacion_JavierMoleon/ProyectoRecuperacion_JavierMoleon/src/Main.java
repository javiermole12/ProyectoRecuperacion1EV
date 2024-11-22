import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa("Compra-Venta Coches");

        // Cargar los datos iniciales
        Empresa.cargarDatosIniciales(empresa);

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

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la ciudad de la sede: ");
                    String ciudad = sc.nextLine();
                    System.out.print("Introduce el tamaño máximo del concesionario: ");
                    int tamanyo = sc.nextInt();
                    empresa.crearSede(ciudad, tamanyo);
                    break;

                case 2:
                    System.out.print("Introduce la marca del coche: ");
                    String marca = sc.nextLine();
                    System.out.print("Introduce el modelo del coche: ");
                    String modelo = sc.nextLine();
                    System.out.print("Introduce la matrícula del coche: ");
                    String matricula = sc.nextLine();
                    System.out.print("Introduce el año del coche: ");
                    int anyo = sc.nextInt();
                    System.out.print("Introduce el precio del coche: ");
                    double precio = sc.nextDouble();
                    System.out.print("Introduce los kms del coche: ");
                    int kms = sc.nextInt();
                    sc.nextLine();  // Consumir salto de línea
                    System.out.print("Introduce la sede en la que se creará el coche: ");
                    String sede = sc.nextLine();

                    Coche coche = new Coche(marca, modelo, matricula, anyo, precio, kms);
                    empresa.introducirCoche(sede, coche);
                    break;

                case 3:
                    System.out.print("Introduce la matrícula del coche que deseas vender: ");
                    String matriculaVender = sc.nextLine();
                    System.out.print("Introduce la sede: ");
                    String sedeVender = sc.nextLine();
                    empresa.venderCoche(sedeVender, matriculaVender);
                    break;

                case 4:
                    System.out.print("Introduce la marca a buscar: ");
                    String marcaBuscar = sc.nextLine();
                    empresa.buscarPorMarca(marcaBuscar);
                    break;

                case 5:
                    System.out.print("Introduce el modelo a buscar: ");
                    String modeloBuscar = sc.nextLine();
                    empresa.buscarPorModelo(modeloBuscar);
                    break;

                case 6:
                    System.out.print("Introduce la sede del concesionario: ");
                    String sedeMostrar = sc.nextLine();
                    empresa.mostrarCochesPorConcesionario(sedeMostrar);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}