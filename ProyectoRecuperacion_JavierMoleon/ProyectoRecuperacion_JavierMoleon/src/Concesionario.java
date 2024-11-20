import java.util.ArrayList;

public class Concesionario {
    private final int tamanyo;
    private double facturacionLocal;
    private ArrayList<Coche> listadoCoches;

    // Constructor
    public Concesionario(int tamanyo) {
        this.tamanyo = tamanyo;
        this.facturacionLocal = 0;
        this.listadoCoches = new ArrayList<>();
    }

    // Métodos
    public void adquirirCoche(Coche coche) {
        if (listadoCoches.size() < tamanyo) {
            listadoCoches.add(coche);
            System.out.println("Coche añadido correctamente.");
        } else {
            System.out.println("Concesionario lleno, no se puede introducir el coche.");
        }
    }

    public void venderCoche(String matricula) {
        for (Coche coche : listadoCoches) {
            if (coche.getMatricula().equals(matricula)) {
                facturacionLocal += coche.getPrecio();
                listadoCoches.remove(coche);
                System.out.println("Coche vendido. Facturación local actualizada.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    public double getFacturacionLocal() {
        return facturacionLocal;
    }

    public ArrayList<Coche> getListadoCoches() {
        return listadoCoches;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coche coche : listadoCoches) {
            sb.append(coche.toString()).append("-----------------------------\n");
        }
        return sb.toString();
    }
}
