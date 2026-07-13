import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<Corredor> rivales = new ArrayList<>();
    static Corredores corredores;
    static Vehiculo vehiculo;
    static Pista pista;
    static Random random = new Random();
    static final String[] PERSONAJES = {"Mario", "Luigi", "Toad", "Peach", "Bowser", "Yoshi"};
    static List<String> resultados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("~~~~~Mario Kart~~~~~");
            System.out.println("Eliga alguna de estas opciones");
            System.out.println("1.Crear corredor");
            System.out.println("2.Crear kart");
            System.out.println("3.Elegir rival");
            System.out.println("4.Elegir pista");
            System.out.println("5.Iniciar carrera");
            System.out.println("6.Resultados y Salir");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    crearcorredor(sc);
                    break;
                case 2:
                    if (corredores == null) {
                        System.out.println("Primero tenes que crear tu corredor (opcion 1).");
                    } else {
                        crearkart(sc);
                    }
                    break;
                case 3:
                    elegirrival(sc);
                    break;
                case 4:
                    elegirpista(sc);
                    break;
                case 5:                    
                if (corredores == null || rivales.size() < 3 || pista == null) {
                        System.out.println("Te falta configurar corredor, rivales o pista.");
                } 
                else {    
                    iniciarcarrera();
                }
                   
                    break;
                case 6:
                    mostrarResultados();
                    System.out.println("Gracias por jugar!");
                    break;
            }
        } while (option != 6);

        sc.close();
    }

    public static void crearcorredor(Scanner sc) {
        System.out.println("Ingrese que corredor desea");
        System.out.println("1. Mario \n 2. Luigi \n 3. Toad \n 4. Peach \n 5. Bowser \n 6. Yoshi");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                corredores = new Corredores("Mario", 30, 3, 2);
                break;
            case 2:
                corredores = new Corredores("Luigi", 33, 2, 2);
                break;
            case 3:
                corredores = new Corredores("Toad", 37, 3, 1);
                break;
            case 4:
                corredores = new Corredores("Peach", 33, 2, 2);
                break;
            case 5:
                corredores = new Corredores("Bowser", 23, 5, 3);
                break;
            case 6:
                corredores = new Corredores("Yoshi", 35, 3, 2);
                break;
            default:
                System.out.println("Opcion invalida, se elige Mario por defecto.");
                corredores = new Corredores("Mario", 30, 3, 2);
        }
    }

    public static void crearkart(Scanner sc) {
        System.out.println("Tipo de vehiculo \n 1. Auto \n 2. Moto");
        int opt = sc.nextInt();

        switch (opt) {
            case 1:
                vehiculo = new Auto();
                break;
            case 2:
                vehiculo = new Moto();
                break;
            default:
                System.out.println("Opcion invalida, se elige Auto por defecto.");
                vehiculo = new Auto();
        }

        System.out.println("Ruedas \n 1. Pequeñas \n 2. Medianas \n 3. Monstruo");
        int a = sc.nextInt();

        switch (a) {
            case 1:
                vehiculo.setRuedas(new Ruedas(-1, -2, 2));
                break;
            case 2:
                vehiculo.setRuedas(new Ruedas(0, 1, 1));
                break;
            case 3:
                vehiculo.setRuedas(new Ruedas(2, 2, 0));
                break;
            default:
                vehiculo.setRuedas(new Ruedas(0, 1, 1));
        }

        System.out.println("Chasis \n 1. liviano \n 2. medio \n 3. pesado");
        int b = sc.nextInt();

        switch (b) {
            case 1:
                vehiculo.setChasis(new Chasis(-2, -2, 2));
                break;
            case 2:
                vehiculo.setChasis(new Chasis(1, 0, 1));
                break;
            case 3:
                vehiculo.setChasis(new Chasis(2, 2, 0));
                break;
            default:
                vehiculo.setChasis(new Chasis(1, 0, 1));
        }
    }

    public static void elegirrival(Scanner sc) {
        rivales.clear();
        System.out.println("Tipo de carrera \n 1. Aleatorio \n 2. Clasico");
        int opt = sc.nextInt();

        if (opt == 1) {
            List<String> nombresDisponibles = new ArrayList<>(Arrays.asList(PERSONAJES));
            if (corredores != null) {
                nombresDisponibles.remove(corredores.getNombre());
            }
            Collections.shuffle(nombresDisponibles);

            for (int i = 0; i < 3; i++) {
                rivales.add(generarCorredorAleatorio(nombresDisponibles.get(i)));
            }
        } else {
            List<Corredor> clasicos = corredoresClasicos();
            Collections.shuffle(clasicos);
            for (int i = 0; i < 3; i++) {
                rivales.add(clasicos.get(i));
            }
        }

        System.out.println("Rivales seleccionados:");
        for (Corredor c : rivales) {
            System.out.println("- " + c.getNombre());
        }
    }

    public static void elegirpista(Scanner sc) {
        System.out.println("Elija la pista \n 1. Circuito Champiñon \n 2. Bahia Delfin \n 3. Estadio Wario");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                pista = new Pista("Circuito Champiñon", 200, 3);
                break;
            case 2:
                pista = new Pista("Bahia Delfin", 300, 3);
                break;
            case 3:
                pista = new Pista("Estadio Wario", 250, 2);
                break;
            default:
                System.out.println("Opcion invalida, se elige Circuito Champiñon por defecto.");
                pista = new Pista("Circuito Champiñon", 200, 3);
        }
    }

    public static void iniciarcarrera() {
        resultados.clear();
        List<Corredor> todos = new ArrayList<>();

        Corredor jugador = new Corredor(corredores, vehiculo);
        jugador.setPista(pista);
        jugador.setResultados(resultados);
        todos.add(jugador);

        for (Corredor rival : rivales) {
            rival.setPista(pista);
            rival.setResultados(resultados);
            todos.add(rival);
        }
        for (Corredor c : todos) {
            c.start();
        }
        for (Corredor c : todos) {
            try {
                c.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void mostrarResultados() {
        if (resultados.isEmpty()) {
            System.out.println("Todavia no se corrió ninguna carrera.");
            return;
        }

        String[] podio = {"1er puesto", "2do puesto", "3er puesto"};

        System.out.println("\n========= TABLA DE RESULTADOS =========");
        for (int i = 0; i < resultados.size(); i++) {
            String etiqueta = i < podio.length ? podio[i] : (i + 1) + "to puesto";
            System.out.printf("%-15s %s%n", etiqueta, resultados.get(i));
        }
        System.out.println("========================================\n");
    }

    public static Corredor generarCorredorAleatorio(String nombre) {
        int velocidad = 30 + random.nextInt(15);
        int pesoBase = random.nextInt(6);
        int capDriftBase = random.nextInt(4);

        Vehiculo vehiculo = random.nextBoolean() ? new Auto() : new Moto();
        String tipoVehiculo = (vehiculo instanceof Auto) ? "Auto" : "Moto";

        Ruedas[] ruedasOpciones = {
                new Ruedas(-1, -2, 2), new Ruedas(0, 1, 1), new Ruedas(2, 2, 0)
        };
        Chasis[] chasisOpciones = {
                new Chasis(-2, -2, 2), new Chasis(1, 0, 1), new Chasis(2, 2, 0)
        };
        vehiculo.setRuedas(ruedasOpciones[random.nextInt(3)]);
        vehiculo.setChasis(chasisOpciones[random.nextInt(3)]);

        System.out.println(nombre + " -> " + tipoVehiculo + ", velocidad " + velocidad);

        return new Corredor(nombre, velocidad, pesoBase ,capDriftBase, vehiculo);
    }
    public static List<Corredor> corredoresClasicos() {
        List<Corredor> lista = new ArrayList<>();

        Vehiculo v1 = new Auto();
        v1.setRuedas(new Ruedas(0, 1, 1));
        v1.setChasis(new Chasis(1, 0, 1));
        lista.add(new Corredor("Luigi", 39, 3, 2, v1));

        Vehiculo v2 = new Moto();
        v2.setRuedas(new Ruedas(-1, -2, 2));
        v2.setChasis(new Chasis(-2, -2, 2));
        lista.add(new Corredor("Peach", 41, 2, 2, v2));

        Vehiculo v3 = new Auto();
        v3.setRuedas(new Ruedas(2, 2, 0));
        v3.setChasis(new Chasis(2, 2, 0));
        lista.add(new Corredor("Bowser", 35, 8, 0, v3));

        Vehiculo v4 = new Moto();
        v4.setRuedas(new Ruedas(0, 1, 1));
        v4.setChasis(new Chasis(-2, -2, 2));
        lista.add(new Corredor("Toad", 42, 1, 3, v4));

        return lista;
    }
}