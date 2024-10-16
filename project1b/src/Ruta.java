import java.util.ArrayList;

public class Ruta {
    private ArrayList<Ubicacion> locations;
    private boolean returnsToStart;

    public Ruta() {
        this.locations = new ArrayList<>();
        this.returnsToStart = false;
    }

    public void addLocation(Ubicacion location) {
        this.locations.add(location.clone());
    }

    public void modifyLocationAtIndex(int pos, Ubicacion location) {
        if (pos >= 0 && pos < locations.size()) {
            locations.set(pos, location.clone());
        }
    }

    public Ubicacion getLocationAtIndex(int pos) {
        if (pos >= 0 && pos < locations.size()) {
            return locations.get(pos).clone();
        }
        return null;
    }

    public boolean doesReturnToStart() {
        if (locations.size() > 0) {
            Ubicacion first = locations.get(0);
            Ubicacion last = locations.get(locations.size() - 1);
            returnsToStart = first.esIgual(last);
        }
        return returnsToStart;
    }

    public double calculateDistance() {
        double totalDistance = 0;
        for (int i = 0; i < locations.size() - 1; i++) {
            totalDistance += locations.get(i).distancia(locations.get(i + 1));
        }
        if (doesReturnToStart()) {
            totalDistance += locations.get(locations.size() - 1).distancia(locations.get(0));
        }
        return totalDistance;
    }

    public Ubicacion calculateNorthernmostLocation() {
        if (locations.isEmpty()) return null;
        Ubicacion northernmost = locations.get(0);
        for (Ubicacion location : locations) {
            if (location.getLatitud() > northernmost.getLatitud()) {
                northernmost = location;
            }
        }
        return northernmost.clone();
    }

    public String toString() {
        StringBuilder aux = new StringBuilder("ROUTE => number of locations: " + locations.size());
        for (int i = 0; i < locations.size(); i++) {
            aux.append("\n\tLocation at position ").append(i).append(": ").append(locations.get(i));
        }
        return aux.toString();
    }
}
