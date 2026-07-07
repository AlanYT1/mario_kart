void main() {
    Scanner sc = new Scanner(System.in);
    int option;
    do {
        System.out.println("Mario Kart");
        System.out.println("1. crear corredor");
        System.out.println("2. crear kart");
        System.out.println("3. elegir rival");
        System.out.println("4. elegir pista");
        System.out.println("5. iniciar carrera");
        System.out.println("6. salir");
        option = sc.nextInt();

        switch(option){
            case 1:
                crearcorredor(sc);
                break;
            case 2:
                crearkart(sc);
                break;
            case 3:
                elegirrival(sc);
                break;
            case 4:
                elegirpista(sc);
                break;
            case 5:
                iniciarcarrera();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }


    }while(option != 6);
}

public static void crearkart(Scanner sc) {
    Vehiculo vehiculo = null;

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
