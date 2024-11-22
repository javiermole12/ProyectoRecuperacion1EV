import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    private String nombre;
    private double facturacionEmpresa;
    private HashMap<String, Concesionario> grupo;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.facturacionEmpresa = 0;
        this.grupo = new HashMap<>();
    }

    public Concesionario getConcesionario(String ciudad) {
        return grupo.get(ciudad);
    }

    // Crear nueva sede
    public void crearSede(String ciudad, int tamanyo) {
        if (!grupo.containsKey(ciudad)) {
            grupo.put(ciudad, new Concesionario(tamanyo));
            System.out.println("Sede en " + ciudad + " creada correctamente.");
        } else {
            System.out.println("La sede ya existe.");
        }
    }

    // Añadir coche a sede
    public void introducirCoche(String ciudad, Coche coche) {
        if (grupo.containsKey(ciudad)) {
            grupo.get(ciudad).adquirirCoche(coche);
        } else {
            System.out.println("ERROR: La sede indicada no existe.");
        }
    }

    // Vender coche en una sede
    public void venderCoche(String ciudad, String matricula) {
        if (grupo.containsKey(ciudad)) {
            grupo.get(ciudad).venderCoche(matricula);
        } else {
            System.out.println("ERROR: La sede indicada no existe.");
        }
    }

    // Facturación total
    public void facturacionTotal() {
        facturacionEmpresa = 0;
        for (Concesionario concesionario : grupo.values()) {
            facturacionEmpresa += concesionario.getFacturacionLocal();
        }
        System.out.println("Facturación total de la empresa: " + facturacionEmpresa + " €");
    }

    // Buscar coches por marca
    public void buscarPorMarca(String marca) {
        boolean encontrado = false;
        for (String ciudad : grupo.keySet()) {
            Concesionario concesionario = grupo.get(ciudad);
            ArrayList<Coche> coincidencias = new ArrayList<>();
            for (Coche coche : concesionario.getListadoCoches()) {
                if (coche.getMarca().equalsIgnoreCase(marca)) {
                    coincidencias.add(coche);
                }
            }
            if (!coincidencias.isEmpty()) {
                System.out.println(coincidencias.size() + " coincidencias en " + ciudad + ":");
                for (Coche coche : coincidencias) {
                    System.out.println(coche);
                }
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("0 coincidencias.");
        }
    }

    // Buscar coches por modelo
    public void buscarPorModelo(String modelo) {
        boolean encontrado = false;
        for (String ciudad : grupo.keySet()) {
            Concesionario concesionario = grupo.get(ciudad);
            ArrayList<Coche> coincidencias = new ArrayList<>();
            for (Coche coche : concesionario.getListadoCoches()) {
                if (coche.getModelo().equalsIgnoreCase(modelo)) {
                    coincidencias.add(coche);
                }
            }
            if (!coincidencias.isEmpty()) {
                System.out.println(coincidencias.size() + " coincidencias en " + ciudad + ":");
                for (Coche coche : coincidencias) {
                    System.out.println(coche);
                }
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("0 coincidencias.");
        }
    }

    public static void cargarDatosIniciales(Empresa empresa) {
        // Crear concesionarios
        empresa.crearSede("Madrid", 7);
        empresa.crearSede("Barcelona", 6);
        empresa.crearSede("Valencia", 8);

        // Crear coches y añadir a los concesionarios
        Concesionario madrid = empresa.getConcesionario("Madrid");
        madrid.adquirirCoche(new Coche("Toyota", "Corolla", "1234ABC", 2015, 12000, 80000));
        madrid.adquirirCoche(new Coche("Honda", "Civic", "5678DEF", 2018, 14000, 60000));
        madrid.adquirirCoche(new Coche("Peugeot", "407", "2329EFG", 2019, 12000, 113000));
        madrid.adquirirCoche(new Coche("Subaru", "Impreza", "9671RFG", 2014, 18000, 103000));

        Concesionario barcelona = empresa.getConcesionario("Barcelona");
        barcelona.adquirirCoche(new Coche("Ford", "Fiesta", "4321GHI", 2017, 10000, 50000));
        barcelona.adquirirCoche(new Coche("BMW", "Serie 3", "8765JKL", 2020, 25000, 30000));
        barcelona.adquirirCoche(new Coche("Yaguar", "XF", "9065HGT", 2021, 35000, 75000));
        barcelona.adquirirCoche(new Coche("BMW", "Serie 5", "3287HNJ", 2018, 22000, 87000));
        barcelona.adquirirCoche(new Coche("Seat", "Ibiza", "1954SAM", 2017, 9000, 60000));

        Concesionario valencia = empresa.getConcesionario("Valencia");
        valencia.adquirirCoche(new Coche("Audi", "A4", "1122MNO", 2016, 22000, 70000));
        valencia.adquirirCoche(new Coche("Mercedes", "Clase C", "3344PQR", 2019, 27000, 45000));
        valencia.adquirirCoche(new Coche("Audi", "A3", "1542GHO", 2017, 22000, 80000));
        valencia.adquirirCoche(new Coche("Ford", "Mondeo", "1058WSY", 2017, 24000, 65000));

        System.out.println("Datos iniciales cargados correctamente.");
    }
}
