public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private int anyo;
    private double precio;
    private int kms;

    // Constructor
    public Coche(String marca, String modelo, String matricula, int anyo, double precio, int kms) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anyo = anyo;
        this.precio = precio;
        this.kms = kms;
    }

    // Métodos getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAnyo() {
        return anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getKms() {
        return kms;
    }

    // Método para aplicar descuento
    public void aplicarDescuento(int descuento) {
        if (descuento < 1 || descuento > 50) {
            System.out.println("ERROR: Debe especificar un valor entre 1 y 50");
        } else {
            precio = precio - (precio * descuento / 100);
        }
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\nModelo: " + modelo + "\nMatrícula: " + matricula + "\nAño: " + anyo +
                "\nPrecio: " + precio + " €\nKms: " + kms + "\n";
    }
}

