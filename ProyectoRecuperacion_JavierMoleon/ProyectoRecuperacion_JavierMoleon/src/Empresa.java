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
}
