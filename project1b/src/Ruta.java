import java.util.ArrayList;

public class Ruta {
    private ArrayList<Ubicacion> ubicaciones;
    private boolean vuelveAlInicio;

    public Ruta() {
        this.ubicaciones = new ArrayList<>();
        this.vuelveAlInicio = false;
    }

    public void afegeixUbicacio(Ubicacion ubicacion) {
        this.ubicaciones.add(ubicacion.clone());
    }

    public void modificaUbicacioIessim(int pos, Ubicacion ubicacion) {
        if (pos >= 0 && pos < ubicaciones.size()) {
            ubicaciones.set(pos, ubicacion.clone());
        }
    }

    public Ubicacion getUbicacioIessim(int pos) {
        if (pos >= 0 && pos < ubicaciones.size()) {
            return ubicaciones.get(pos).clone();
        }
        return null;
    }

    public boolean isVuelveAlInicio() {
        if (ubicaciones.size() > 0) {
            Ubicacion first = ubicaciones.get(0);
            Ubicacion last = ubicaciones.get(ubicaciones.size() - 1);
            vuelveAlInicio = first.esIgual(last);
        }
        return vuelveAlInicio;
    }

    public double calcularDistancia() {
        double distanciaTotal = 0;
        for (int i = 0; i < ubicaciones.size() - 1; i++) {
            distanciaTotal += ubicaciones.get(i).distancia(ubicaciones.get(i + 1));
        }
        if (isVuelveAlInicio()) {
            distanciaTotal += ubicaciones.get(ubicaciones.size() - 1).distancia(ubicaciones.get(0));
        }
        return distanciaTotal;
    }

    public Ubicacion calcularUbicacionMasAlNorte() {
        if (ubicaciones.isEmpty()) return null;
        Ubicacion masAlNorte = ubicaciones.get(0);
        for (Ubicacion ubicacion : ubicaciones) {
            if (ubicacion.getLatitud() > masAlNorte.getLatitud()) {
                masAlNorte = ubicacion;
            }
        }
        return masAlNorte.clone();
    }

    public String toString() {
        StringBuilder aux = new StringBuilder("RUTA => nombre de ubicaciones: " + ubicaciones.size());
        for (int i = 0; i < ubicaciones.size(); i++) {
            aux.append("\n\tUbicacion posicion ").append(i).append(": ").append(ubicaciones.get(i));
        }
        return aux.toString();
    }
}
