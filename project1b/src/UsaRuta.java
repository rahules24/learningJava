public class UsaRuta {
    public static void main(String[] args) {
        // Test default constructor (with default size of 10)
        System.out.println("Testing Default Constructor:");
        Ruta rutaDefault = new Ruta();

        Ubicacion u1 = new Ubicacion(40.7128, -74.0060);
        Ubicacion u2 = new Ubicacion(34.0522, -118.2437);
        Ubicacion u3 = new Ubicacion(51.5074, -0.1278);
        Ubicacion u4 = new Ubicacion(40.7128, -74.0060);

        rutaDefault.addLocation(u1);
        rutaDefault.addLocation(u2);
        rutaDefault.addLocation(u3);
        rutaDefault.addLocation(u4);

        System.out.println("Route Details: \n" + rutaDefault);
        System.out.println("Total Distance of the Route: " + String.format("%.4f km", rutaDefault.calculateDistance()));
        System.out.println("Northernmost Location: " + rutaDefault.calculateNorthernmostLocation());
        System.out.println("Does the route return to the starting point? " + rutaDefault.doesReturnToStart());

        // Test constructor with fixed size
        System.out.println("\nTesting Constructor with Fixed Size:");
        Ruta rutaFixed = new Ruta(3);
        
        Ubicacion u5 = new Ubicacion(48.8566, 2.3522);
        Ubicacion u6 = new Ubicacion(52.5200, 13.4050);
        Ubicacion u7 = new Ubicacion(40.7128, -74.0060);

        rutaFixed.addLocation(u5);
        rutaFixed.addLocation(u6);
        rutaFixed.addLocation(u7);

        System.out.println("Route Details: \n" + rutaFixed);
        System.out.println("Total Distance of the Route: " + String.format("%.4f km", rutaFixed.calculateDistance()));
        System.out.println("Northernmost Location: " + rutaFixed.calculateNorthernmostLocation());
        System.out.println("Does the route return to the starting point? " + rutaFixed.doesReturnToStart());

        // Test constructor that takes an array of locations
        System.out.println("\nTesting Constructor with Array of Locations:");
        Ubicacion[] locationsArray = {u1, u2, u3, u4};
        Ruta rutaArray = new Ruta(locationsArray);

        System.out.println("Route Details: \n" + rutaArray);
        System.out.println("Total Distance of the Route: " + String.format("%.4f km", rutaArray.calculateDistance()));
        System.out.println("Northernmost Location: " + rutaArray.calculateNorthernmostLocation());
        System.out.println("Does the route return to the starting point? " + rutaArray.doesReturnToStart());

        // Modifying a location in the default constructor route
        System.out.println("\nTesting Modification of a Location:");
        Ubicacion newLocation = new Ubicacion(48.8566, 2.3522);
        rutaDefault.modifyLocationAtIndex(1, newLocation);       // Modify the second location

        System.out.println("Updated Route Details: \n" + rutaDefault);
        System.out.println("Total Distance of the Route: " + String.format("%.4f km", rutaDefault.calculateDistance()));
        System.out.println("Northernmost Location: " + rutaDefault.calculateNorthernmostLocation());
        System.out.println("Does the route return to the starting point? " + rutaDefault.doesReturnToStart());
    }
}
