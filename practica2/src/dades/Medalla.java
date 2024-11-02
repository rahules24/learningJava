package dades;

public class Medalla {
    // Attributes of the Medalla class
    private String discipline;
    private String gamesLocation;
    private int gamesYear;
    private String eventName;
    private String gender;
    private String medalType;
    private String participationType;
    private String athleteCountry;

    // Constructor that receives medal data
    public Medalla(String discipline, String gamesLocation, int gamesYear, String eventName, String gender, 
                   String medalType, String participationType, String athleteCountry) {
        this.discipline = discipline;
        this.gamesLocation = gamesLocation;
        this.gamesYear = gamesYear;
        this.eventName = eventName;
        this.gender = gender;
        this.medalType = medalType;
        this.participationType = participationType;
        this.athleteCountry = athleteCountry;
    }

    @Override
    // toString method returns the object's content as a string
    public String toString() {
        return "Medal [discipline=" + discipline + ", gamesLocation=" + gamesLocation + ", gamesYear=" + gamesYear
                + ", eventName=" + eventName + ", gender=" + gender + ", medalType=" + medalType 
                + ", participationType=" + participationType + ", athleteCountry=" + athleteCountry + "]";
    }

    // Method that creates a copy of the current object
    // Returns a new instance of Medalla with the same content as the current object
    public Medalla copia() {
        return new Medalla(discipline, gamesLocation, gamesYear, eventName, gender, medalType, participationType, athleteCountry);
    }

    // Method to check if the current instance's gamesLocation matches the parameter
    // @param cityName contains the city to check
    // @return true if the current medal's gamesLocation matches the parameter, false otherwise
    public boolean celebratEn(String cityName) {
        return gamesLocation.equalsIgnoreCase(cityName);
    }
    
    // Method to check if the gamesYear of the current instance matches the parameter
    // @return true if the current medal's gamesYear matches the parameter, false otherwise
    public boolean celebratAny(int gamesYear) {
        return this.gamesYear == gamesYear;
    }

    // Method to check if the current instance's medalType matches the parameter
    // @param medalTypeParam contains the medal type to check
    // @return true if the current medal type matches the parameter, false otherwise
    public boolean esTipusMedalla(String medalTypeParam) {
        return medalType.equalsIgnoreCase(medalTypeParam);
    }

    // Method to check if the current instance's athleteCountry matches the parameter
    // @param country contains the country to check
    // @return true if the current medal's athleteCountry matches the parameter, false otherwise
    public boolean esDaquestPais(String country) {
        return athleteCountry.equalsIgnoreCase(country);
    }

    // Method to check if the current instance's gender matches the parameter
    // @param genderParam contains the gender to check
    // @return true if the current medal's gender matches the parameter, false otherwise
    public boolean esDaquestSexe(String genderParam) {
        return gender.equalsIgnoreCase(genderParam);
    }

    // Getter that returns the athlete's country
    public String getPais() {
        return athleteCountry;
    }

    // Method to check if the eventName of the current instance matches the parameter
    // @return true if the current medal's eventName matches the parameter, false otherwise
    public boolean esAquestaProva(String eventName) {
        return this.eventName.equalsIgnoreCase(eventName);
    }
}
