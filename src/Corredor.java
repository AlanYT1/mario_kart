import java.util.Random;

public class Corredor extends Thread {
    private String nombre;
    private int velocidad;
    private Vehiculo vehiculo;
    private int distancia;
    private boolean termino = false;

    public Corredor(String nombre, int velocidad, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.distancia = 0;
    }

    public void iniciarcarrera() {
        while (!termino) {
            try {
                avanzar();
                caida();
                boost();

                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    Random r = new Random();

    public void avanzar(){
        double velocidadfinal = velocidad - (vehiculo.getPeso() * 3);
        distancia += velocidadfinal;

    }

    public void caida(){
        double porcentaje = 10 - vehiculo.getEstabilidad();
        if (porcentaje > 0) {
            porcentaje = porcentaje * 0.05f;
            if(r.nextInt(100)<porcentaje){
                distancia -= 5;
            }
        }
    }

    public void boost(){
        double porcentaje = vehiculo.getDrift() - 10;
        if (porcentaje > 0) {
            porcentaje = porcentaje * 0.05f;
            if(r.nextInt(100)<porcentaje){
                distancia += 10;
            }
        }
    }
}