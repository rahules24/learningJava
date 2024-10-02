public class UsaUbicacion {

    private static void mostraUbicacion(Ubicacion ubicacion) {
        System.out.println(ubicacion.toString());
    }

    public static void main(String[] args) {
		Ubicacion ubicacion, ubicacion2;

        System.out.println("Constructor sense parametres");
		ubicacion = new Ubicacion();
		mostraUbicacion(ubicacion);

		System.out.println("Constructor amb parametres, ubicacion correcta");
		ubicacion2 = new Ubicacion(55.69874, 69.3475);
		mostraUbicacion(ubicacion2);

		System.out.println("Constructor amb parametres, ubicacion incorrecta");
		ubicacion = new Ubicacion(128.4899, -357.8742);
		mostraUbicacion(ubicacion);

        validacioIgual();
		validacioDistancia();

        System.out.println("ubicacion"+ubicacion2.toString());
        System.out.println("ubicacion clone "+ubicacion2.clone().toString());
    }

    private static void validacioIgual() {
        // Validació del mètode esIgual
        Ubicacion ubicacion, ubicacion2;
        System.out.println("comprova si dos ubicacions son iguals, ubicacions iguals");
        ubicacion = new Ubicacion(-28.2438, 5.5731);
        ubicacion2 = new Ubicacion(-28.2438, 5.5731);
        System.out.println(ubicacion.esIgual(ubicacion2));
    
        System.out.println("comprova si dos ubicacions son iguals, ubicacions diferents");
        ubicacion = new Ubicacion(27.1247, 112.1314);
        ubicacion2 = new Ubicacion(7.9874, 127.8632);
        System.out.println(ubicacion.esIgual(ubicacion2));
    }

    private static void validacioDistancia() {
        // Validació del mètode distancia
        Ubicacion ubicacion, ubicacion2;
        System.out.println("comprova la distancia entre dos ubicacions");
        ubicacion = new Ubicacion(27.1247, 112.1314);
        ubicacion2 = new Ubicacion(7.9874, 127.8632);
        System.out.println(ubicacion.distancia(ubicacion2));
        System.out.println("distancia real: 2700.1448");
    }

}
