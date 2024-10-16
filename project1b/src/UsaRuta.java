public class UsaRuta {
    public static void main(String[] args) {
        Ruta ruta = new Ruta();
        
        Ubicacion u1 = new Ubicacion(40.7128, -74.0060); // New York
        Ubicacion u2 = new Ubicacion(34.0522, -118.2437); // Los Angeles
        Ubicacion u3 = new Ubicacion(51.5074, -0.1278); // London
        Ubicacion u4 = new Ubicacion(40.7128, -74.0060); // New York

        ruta.afegeixUbicacio(u1);
        ruta.afegeixUbicacio(u2);
        ruta.afegeixUbicacio(u3);
        ruta.afegeixUbicacio(u4);

        System.out.println("Detalles de la ruta: " + ruta);
        System.out.println("Distancia total de la ruta: " + String.format("%.4f km", ruta.calcularDistancia()));
        System.out.println("Ubicación más al norte: " + ruta.calcularUbicacionMasAlNorte());
        System.out.println("¿La ruta vuelve al inicio? " + ruta.isVuelveAlInicio());
    }
}
