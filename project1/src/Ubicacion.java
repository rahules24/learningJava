public class Ubicacion {
    private double latitud;
    private double longitud;

    public Ubicacion() {
        this.latitud = 0;
        this.longitud = 0;
    }

    /**
     * Constructor
     * @param latitud
     * @param longitud
     */

    public Ubicacion(double latitud, double longitud) {
        if (esUbicacionCorrecta(latitud, longitud)) {
        this.latitud = latitud;
        this.longitud = longitud;
        }
    }

    /** Getters
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }
    
    /** Getters
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /** Setters
     * @param latitud
     * @param longitud
     */
    public void setUbicacion(double latitud, double longitud) {
        if (esUbicacionCorrecta(latitud, longitud)) {
        this.longitud = longitud;
        this.latitud = latitud;
        }
    }

    private static boolean esUbicacionCorrecta(double latitud, double longitud) {
		boolean hoEs=true;
		if (latitud > 90 || latitud < -90) { 
			hoEs= false;
		}
		if (longitud > 180 || longitud < -180) { 
			hoEs= false;
		}
		return hoEs;
	}

    public String toString() {
		return("\tDATA => latitud "+latitud+" longitud "+longitud);
	}

    	public boolean esIgual(Ubicacion ubicacion) {
		if (this.latitud*10000 == ubicacion.latitud*10000 && this.longitud*10000 == ubicacion.longitud*10000) {
			return true;
		}
		return false;
	}

    public Ubicacion clone() {
        return new Ubicacion(this.latitud, this.longitud);
    }

    public String distancia(Ubicacion ubicacion) {
        double latRad1 = Math.toRadians(this.latitud);
        double longRad1 = Math.toRadians(this.longitud);
        double latRad2 = Math.toRadians(ubicacion.latitud);
        double longRad2 = Math.toRadians(ubicacion.longitud);

        double R = 6378.137;
        double a = Math.pow(Math.sin((latRad2 - latRad1)/2), 2) + Math.cos(latRad1) * Math.cos(latRad2) * Math.pow((Math.sin(( longRad2 - longRad1)/2)),2);

        double distance = R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return String.format("%.4f km", distance);
    }
}
