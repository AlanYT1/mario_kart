public class Corredores {
    private String nombre;
    private int velocidad;
    private int drift;
    private int peso;

    public Corredores(String nombre, int velocidad, int drift, int peso) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.drift = drift;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getDrift() {
        return drift;
    }

    public int getPeso() {
        return peso;
    }

}
