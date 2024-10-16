public class Ruta {
    private Ubicacion[] locations;
    private boolean returnsToStart;
    private int currentSize;

    // Default constructor
    public Ruta() {
        this.locations = new Ubicacion[10]; // Default size of 10
        this.returnsToStart = false;
        this.currentSize = 0;
    }

    // Constructor with fixed size
    public Ruta(int numLocations) {
        this.locations = new Ubicacion[numLocations];
        this.returnsToStart = false;
        this.currentSize = 0;
    }

    // Constructor that accepts an array of locations
    public Ruta(Ubicacion[] inputLocations) {
        this.locations = new Ubicacion[inputLocations.length];
        for (Ubicacion loc : inputLocations) {
            this.addLocation(loc);
        }
        this.returnsToStart = false;
    }

    // Add a location to the route
    public void addLocation(Ubicacion location) {
        if (currentSize < locations.length) {
            locations[currentSize++] = location.clone();
        } else {
            System.out.println("Cannot add more locations, array is full.");
        }
    }

    // Modify a location at a given index
    public void modifyLocationAtIndex(int pos, Ubicacion location) {
        if (pos >= 0 && pos < currentSize) {
            locations[pos] = location.clone();
        }
    }

    // Get the location at a given index
    public Ubicacion getLocationAtIndex(int pos) {
        if (pos >= 0 && pos < currentSize) {
            return locations[pos].clone();
        }
        return null;
    }

    // Check if the route returns to the starting point
    public boolean doesReturnToStart() {
        if (currentSize > 0) {
            Ubicacion first = locations[0];
            Ubicacion last = locations[currentSize - 1];
            returnsToStart = first.esIgual(last);
        }
        return returnsToStart;
    }

    // Calculate total distance of the route
    public double calculateDistance() {
        double totalDistance = 0;
        for (int i = 0; i < currentSize - 1; i++) {
            totalDistance += locations[i].distancia(locations[i + 1]);  // Uses Ubicacion's distancia method
        }
        if (doesReturnToStart()) {
            totalDistance += locations[currentSize - 1].distancia(locations[0]);  // Uses Ubicacion's distancia method
        }
        return totalDistance;
    }

    // Find the northernmost location in the route
    public Ubicacion calculateNorthernmostLocation() {
        if (currentSize == 0) return null;
        Ubicacion northernmost = locations[0];
        for (int i = 1; i < currentSize; i++) {
            if (locations[i].getLatitud() > northernmost.getLatitud()) {
                northernmost = locations[i];
            }
        }
        return northernmost.clone();
    }

    // Return a string representation of the route
    public String toString() {
        StringBuilder aux = new StringBuilder("ROUTE => number of locations: " + currentSize);
        for (int i = 0; i < currentSize; i++) {
            aux.append("\n\tLocation at position ").append(i).append(": ").append(locations[i]);
        }
        return aux.toString();
    }
}
