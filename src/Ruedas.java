public class Ruedas {
    private int estabilidad;
    private int peso;
    private int drift;

    public Ruedas(int estabilidad, int peso, int drift) {
        this.estabilidad = estabilidad;
        this.peso = peso;
        this.drift = drift;
    }

    public int getEstabilidad() {
        return estabilidad;
    }

    public int getPeso() {
        return peso;
    }

    public int getDrift() {
        return drift;
    }
}
