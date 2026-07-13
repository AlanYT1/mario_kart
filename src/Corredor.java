import java.util.List;
import java.util.Random;
 
public class Corredor extends Thread {
 
    private final String nombre;
    private final int velocidad;
    private final int peso;
    private final int drift;
    private final Vehiculo vehiculo;
    private Pista pista;
    private List<String> resultados;
    private double distancia;
    private boolean termino = false;
    private final Random r = new Random();
    public Corredor(String nombre, int velocidad, int peso, int drift, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.peso = peso;
        this.drift = drift;
        this.vehiculo = vehiculo;
    }
    public Corredor(Corredores corredores, Vehiculo vehiculo) {
        this(corredores.getNombre(), corredores.getVelocidad(),
                corredores.getPeso(), corredores.getDrift(), vehiculo);
    }
 
    public void setPista(Pista pista) {
        this.pista = pista;
    }
 
    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }
    @Override
    public void run() {
        if (pista == null) {
            throw new IllegalStateException(
                    "Falta asignar la pista");
        }
        while (!termino) {
            try {
                avanzar();
                caida();
                boost();
 
                int vueltaActual = Math.min(
                        (int) (distancia / pista.getLongitud()) + 1,
                        pista.getVueltas()
                );
 
                System.out.printf("Corredor %s | Distancia: %.1f | Vuelta %d/%d%n",
                        nombre, distancia, vueltaActual, pista.getVueltas());
 
                if (distancia >= pista.getDistanciaTotal()) {
                    termino = true;
                    System.out.println(nombre + " terminó la carrera en " + pista.getNombre() + "!");
                    if (resultados != null) {
                        synchronized (resultados) {
                            resultados.add(nombre);
                        }
                    }
                }
 
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                termino = true;
            }
        }
    }
 
    public void avanzar() {
        double velocidadFinal = velocidad - (vehiculo.getPeso() + peso);
        if (velocidadFinal < 0) {
            velocidadFinal = 0;
        }
        distancia += velocidadFinal;
    }
 
    public void caida() {
        double porcentaje = 10 - vehiculo.getEstabilidad();
        if (porcentaje > 0) {
            porcentaje *= 0.05;
            if (r.nextInt(100) < porcentaje) {
                distancia = Math.max(0, distancia - 5);
            }
        }
    }
 
    public void boost() {
        double porcentaje = (vehiculo.getDrift() + drift) - 10;
        if (porcentaje > 0) {
            porcentaje *= 0.05;
            if (r.nextInt(100) < porcentaje) {
                distancia += 10;
            }
        }
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public double getDistancia() {
        return distancia;
    }
}