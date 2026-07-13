public class Vehiculo {
    protected int estabilidad;
    protected int peso;
    protected int drift;

    protected Ruedas ruedas;
    protected Chasis chasis;

    public Vehiculo(int estabilidad, int peso, int drift) {
        this.estabilidad = estabilidad;
        this.peso = peso;
        this.drift = drift;
    }

    public void setRuedas(Ruedas ruedas) {
        this.ruedas = ruedas;
    }

    public void setChasis(Chasis chasis) {
        this.chasis = chasis;
    }

    public int getEstabilidad() {
        return estabilidad + ruedas.getEstabilidad() + chasis.getEstabilidad();
    }

    public int getPeso() {
        return peso + ruedas.getPeso() + chasis.getPeso();
    }

    public int getDrift() {
        return drift + ruedas.getDrift() + chasis.getDrift();
    }
}
