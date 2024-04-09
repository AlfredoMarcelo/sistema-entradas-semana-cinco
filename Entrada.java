package sistemadeentradass5;

public class Entrada {
    //atributos Variables de INSTANCIA
    private String ubicacion;
    private String numeroAsiento;
    private double precio;

    public Entrada() {
    }
    
    public Entrada(String ubicacion, String numeroAsiento, double precio) {
        this.ubicacion = ubicacion;
        this.numeroAsiento = numeroAsiento;
        this.precio = precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }


    public double getPrecio() {
        return precio;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    @Override
    public String toString() {
        return "Entrada{" + "ubicacion=" + ubicacion + ", numeroAsiento=" + numeroAsiento + ", precio=" + precio + '}';
    } 
}
