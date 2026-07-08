import java.util.Random;


public class Corredor extends Thread {
    private String nombre;
    private int velocidad;
    private Vehiculo vehiculo;
    private double distancia;
    private boolean termino = false;
    private Corredores corredores;

    public Corredor(Corredores corredores, Vehiculo vehiculo) {
        this.corredores = corredores;
        this.nombre = corredores.getNombre();
        this.velocidad = corredores.getVelocidad();
        this.vehiculo = vehiculo;
    }

    public void run() {
        while (!termino) {
            try {
                avanzar();
                caida();
                boost();
                System.out.println("Corredor " + this.nombre);
                System.out.println("Distancia: " + distancia);
                if (distancia >= pista.getDistancia() && vuelta > pista.getVuelta()){
                    termino = true;
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    Random r = new Random();

    public void avanzar(){
        double velocidadfinal = velocidad - ((vehiculo.getPeso() + corredores.getPeso()) * 3);
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
        double porcentaje = (vehiculo.getDrift() + corredores.getDrift()) - 10;
        if (porcentaje > 0) {
            porcentaje = porcentaje * 0.05f;
            if(r.nextInt(100)<porcentaje){
                distancia += 10;
            }
        }
    }
}