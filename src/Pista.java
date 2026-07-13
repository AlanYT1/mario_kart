public class Pista {
    private String nombre;
    private double longitud;
    private int vueltas;

    public Pista(String nombre, double longitud, int vueltas) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.vueltas = vueltas;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public int getVueltas() {
        return vueltas;
    }

    public double getDistanciaTotal() {
        return longitud * vueltas;
    }
}
