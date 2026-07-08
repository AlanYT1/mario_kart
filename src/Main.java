static Corredores corredores;
static Vehiculo vehiculo;

void main() {
    Scanner sc = new Scanner(System.in);
    crearcorredor(sc);
    crearkart(sc);
    elegirrival(sc);
    elegirpista(sc);
    iniciarcarrera();
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
            corredores = new Corredores("Luigi", 33,2, 2);
            break;
        case 3:
            corredores = new Corredores("Toad", 37,3, 1);
            break;
        case 4:
            corredores = new Corredores("Peach", 33,2, 2);
            break;
        case 5:
            corredores = new Corredores("Bowser", 23,5,3);
            break;
        case 6:
            corredores = new Corredores("Yoshi", 35,3,2);
            break;
    }
}

public static void crearkart(Scanner sc) {

    System.out.println("Tipo de vehiculo \n 1. Auto \n 2. Moto");
    int opt = sc.nextInt();

    switch (opt){
        case 1:
            vehiculo = new Auto();
            break;
        case 2:
            vehiculo = new Moto();
            break;
    }
    System.out.println("Ruedas \n 1. Pequeñas \n 2. Medianas \n 3. Monstruo");
    int a = sc.nextInt();

    switch (a){
        case 1:
            vehiculo.setRuedas(new Ruedas(-1,-2,2));
            break;
        case 2:
            vehiculo.setRuedas(new Ruedas(0,1,1));
            break;
        case 3:
            vehiculo.setRuedas(new Ruedas(2,2,0));
            break;
    }
    System.out.println("Chasis \n 1. liviano \n 2. medio \n 3. pesado");
    int b =  sc.nextInt();

    switch (b){
        case 1:
            vehiculo.setChasis(new Chasis(-2,-2,2));
            break;
        case 2:
            vehiculo.setChasis(new Chasis(1,0,1));
            break;
        case 3:
            vehiculo.setChasis(new Chasis(2,2,0));
            break;
    }
}

public static void elegirrival(Scanner sc) {

}

public static void elegirpista(Scanner sc) {

}

public static void iniciarcarrera() {
    Corredor corredor = new Corredor(corredores, vehiculo);
    corredor.start();
}