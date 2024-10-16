public class UsaRuta {
    public static void main(String[] args) {
        Ruta ruta = new Ruta();
        
        Ubicacion u1 = new Ubicacion(40.7128, -74.0060);
        Ubicacion u2 = new Ubicacion(34.0522, -118.2437);
        Ubicacion u3 = new Ubicacion(51.5074, -0.1278);
        Ubicacion u4 = new Ubicacion(40.7128, -74.0060);

        ruta.addLocation(u1);
        ruta.addLocation(u2);
        ruta.addLocation(u3);
        ruta.addLocation(u4);

        System.out.println("Route Details: " + ruta);
        System.out.println("Total Distance of the Route: " + String.format("%.4f km", ruta.calculateDistance()));
        System.out.println("Northernmost Location: " + ruta.calculateNorthernmostLocation());
        System.out.println("Does the route return to the starting point? " + ruta.doesReturnToStart());
    }
}
