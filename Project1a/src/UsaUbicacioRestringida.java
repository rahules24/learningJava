public class UsaUbicacioRestringida {

    private static void mostraUbicacioRestringida(UbicacioRestringida ubicacioRestringida) {
        System.out.println(ubicacioRestringida.toString());
    }

    public static void main(String[] args) {

        System.out.println(UbicacioRestringida.getLimitesRegion());

        UbicacioRestringida ubicacioRestringida, ubicacioRestringida2;

        System.out.println("Constructor sense parametres");
        ubicacioRestringida = new UbicacioRestringida();
        mostraUbicacioRestringida(ubicacioRestringida);

        System.out.println("Constructor amb parametres, ubicacion dins de la regio");
        ubicacioRestringida2 = new UbicacioRestringida(20.69874, 69.3475);
        mostraUbicacioRestringida(ubicacioRestringida2);

        System.out.println("Constructor amb parametres, ubicacion fora de la regio");
        ubicacioRestringida = new UbicacioRestringida(128.4899, -357.8742);
        mostraUbicacioRestringida(ubicacioRestringida);
        System.out.println("it returns 0.0, 0.0 because uninitialized double variables are set to 0.0 by default in java");

        validacioIgual();
        validacioDistancia();

        System.out.println("Ampliar regio");
        UbicacioRestringida.ampliarRegion(0.0, 0.0, 150.0, 170.0);
        System.out.println(UbicacioRestringida.getLimitesRegion());


        System.out.println("Ubicacio Restringida: " + ubicacioRestringida2.toString());
        System.out.println("Ubicacio Restringida clonada: " + ubicacioRestringida2.clone().toString());
    }

    private static void validacioIgual() {
        UbicacioRestringida ubicacioRestringida, ubicacioRestringida2;
        System.out.println("comprova si dues ubicacions restringides son iguals, ubicacions iguals");
        ubicacioRestringida = new UbicacioRestringida(25.2438, 15.5731);
        ubicacioRestringida2 = new UbicacioRestringida(25.2438, 15.5731);
        System.out.println(ubicacioRestringida.esIgual(ubicacioRestringida2));
    
        System.out.println("comprova si dues ubicacions restringides son iguals, ubicacions diferents");
        ubicacioRestringida = new UbicacioRestringida(27.1247, 12.1314);
        ubicacioRestringida2 = new UbicacioRestringida(17.9874, 27.8632);
        System.out.println(ubicacioRestringida.esIgual(ubicacioRestringida2));
    }

    private static void validacioDistancia() {
        UbicacioRestringida ubicacioRestringida, ubicacioRestringida2;
        System.out.println("comprova la distancia entre dues ubicacions restringides");
        ubicacioRestringida = new UbicacioRestringida(27.1247, 12.1314);
        ubicacioRestringida2 = new UbicacioRestringida(17.9874, 27.8632);
        System.out.println(ubicacioRestringida.distancia(ubicacioRestringida2));
        System.out.println("distancia real: 1907.7168 km");
    }
}
