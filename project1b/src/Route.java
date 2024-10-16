public class Route {
        private double latitud;
        private double longitud;
    
        public Route() {
            this.latitud = 0;
            this.longitud = 0;
        }
    
        /**
         * Constructor
         * @param latitud
         * @param longitud
         */
        public Route(double latitud, double longitud) {
            if (esRouteCorrecta(latitud, longitud)) {
                this.latitud = latitud;
                this.longitud = longitud;
            } else {
                // Set default values if the input values are incorrect
                this.latitud = 0;
                this.longitud = 0;
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
        public void setRoute(double latitud, double longitud) {
            if (esRouteCorrecta(latitud, longitud)) {
                this.longitud = longitud;
                this.latitud = latitud;
            }
        }
    
        private static boolean esRouteCorrecta(double latitud, double longitud) {
            boolean hoEs = true;
            if (latitud > 90 || latitud < -90) { 
                hoEs = false;
            }
            if (longitud > 180 || longitud < -180) { 
                hoEs = false;
            }
            return hoEs;
        }
    
        public String toString() {
            return ("\tDATA => latitud " + latitud + " longitud " + longitud);
        }
    
        public boolean esIgual(Route route) {
            // Remove the decimal part by casting to int after multiplying by 10000
            return (int)(this.latitud * 10000) == (int)(route.latitud * 10000) && 
                   (int)(this.longitud * 10000) == (int)(route.longitud * 10000);
        }
    
        public Route clone() {
            return new Route(this.latitud, this.longitud);
        }
    
        public String distancia(Route route) {
            double latRad1 = Math.toRadians(this.latitud);
            double longRad1 = Math.toRadians(this.longitud);
            double latRad2 = Math.toRadians(route.latitud);
            double longRad2 = Math.toRadians(route.longitud);
    
            double R = 6378.137;
            double a = Math.pow(Math.sin((latRad2 - latRad1) / 2), 2) + 
                       Math.cos(latRad1) * Math.cos(latRad2) * 
                       Math.pow((Math.sin((longRad2 - longRad1) / 2)), 2);
    
            double distance = R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    
            return String.format("%.4f km", distance);
        }    
}
