public class UbicacioRestringida {

    private static double latIni=10.0000, lonIni=10.0000, latFi=100.0000, lonFi=100.0000;
    private double latitud, longitud;

    public UbicacioRestringida() {
        this.latitud = latIni;
        this.longitud =lonIni;
    }

    public UbicacioRestringida(double latitud, double longitud) {
        if (esUbicacionCorrecta(latitud, longitud)) {
            this.latitud = latitud;
            this.longitud = longitud;
        }
    }
    
    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setUbicacion(double latitud, double longitud) {
        if (esUbicacionCorrecta(latitud, longitud)) {
            this.latitud = latitud;
            this.longitud = longitud;
        }
    }

    private static boolean esUbicacionCorrecta(double latitud, double longitud) {
        return latitud >= latIni && latitud <= latFi && longitud >= lonIni && longitud <= lonFi;
    }

    public static void ampliarRegion(double nuevaLatIn, double nuevaLonIn, double nuevaLatFi, double nuevaLonFi) {
        if (nuevaLatIn < latIni) {
            latIni = nuevaLatIn;
        }
        if (nuevaLonIn < lonIni) {
            lonIni = nuevaLonIn;
        }
    
        if (nuevaLatFi > latFi) {
            latFi = nuevaLatFi;
        }
        if (nuevaLonFi > lonFi) {
            lonFi = nuevaLonFi;
        }
    }
    
    public static String getLimitesRegion() {
        return String.format("Limites de la region: (%f, %f) - (%f, %f)", latIni, lonIni, latFi, lonFi);
    }

    public String toString() {
        return String.format("Ubicacion restringida: latitud %.4f, longitud %.4f", latitud, longitud);
    }

    public boolean esIgual(UbicacioRestringida ubicacion) {
        return this.latitud * 10000 == ubicacion.latitud * 10000 && this.longitud * 10000 == ubicacion.longitud * 10000;
    }

    public UbicacioRestringida clone() {
        return new UbicacioRestringida(this.latitud, this.longitud);
    }

    public String distancia(UbicacioRestringida ubicacion) {
        double latRad1 = Math.toRadians(this.latitud);
        double longRad1 = Math.toRadians(this.longitud);
        double latRad2 = Math.toRadians(ubicacion.latitud);
        double longRad2 = Math.toRadians(ubicacion.longitud);

        double R = 6378.137;
        double a = Math.pow(Math.sin((latRad2 - latRad1) / 2), 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.pow(Math.sin((longRad2 - longRad1) / 2), 2);
        double distance = R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return String.format("%.4f km", distance);
    }
}
