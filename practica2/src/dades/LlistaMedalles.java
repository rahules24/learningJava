package dades;

public class LlistaMedalles {
    private Medalla[] llista;
    private int numMedalles;

    // Constructor to initialize the list with a given size
    public LlistaMedalles(int dimensio) {
        llista = new Medalla[dimensio];
        numMedalles = 0;
    }

    // Getter method that returns the number of medals in the list
    public int getNumMedalles() {
        return numMedalles;
    }

    // Method to create a copy of the current LlistaMedalles object
    public LlistaMedalles copia() {
        LlistaMedalles novaCopia = new LlistaMedalles(llista.length);
        for (int i = 0; i < numMedalles; i++) {
            novaCopia.afegirMedalla(llista[i].copia()); // Add a copy of each medal
        }
        return novaCopia;
    }

    // toString method to display the list details
    @Override
    public String toString() {
        String aux = "List => Number of medals: " + numMedalles;
        for (int i = 0; i < numMedalles; i++) {
            aux += "\n\tMedal " + (i + 1) + ": " + llista[i].toString();
        }
        return aux;
    }

    // 1. Method to add a medal to the list
    public void afegirMedalla(Medalla m) {
        if (numMedalles < llista.length) {
            llista[numMedalles] = m.copia();
            numMedalles++;
        }
    }

    // 2. Method to count medals won by a country in a specific edition
    public int medallesPais(String ciutat, int any, String tMedalla, String pais) {
        int totalMedals = 0;
        for (int i = 0; i < numMedalles; i++) {
            Medalla medalla = llista[i];
            if (medalla.celebratEn(ciutat)
                    && medalla.celebratAny(any)
                    && medalla.esTipusMedalla(tMedalla)
                    && medalla.esDaquestPais(pais)) {
                totalMedals++;
            }
        }
        return totalMedals;
    }

    // 3. Method to find the first medal matching the type, gender, and year
    public Medalla cercaPrimeraMedalla(String tMedalla, String sexe, int any) {
        for (int i = 0; i < numMedalles; i++) {
            Medalla medalla = llista[i];
            if (medalla.celebratAny(any)
                    && medalla.esTipusMedalla(tMedalla)
                    && medalla.esDaquestSexe(sexe)) {
                return medalla;
            }
        }
        return null;
    }

    // 4. Method to find the first medal won by a woman in a specified year and city
    public Medalla primeraMedallaDona(int any, String ciutat) {
        for (int i = 0; i < numMedalles; i++) {
            Medalla medalla = llista[i];
            if (medalla.celebratAny(any)
                    && medalla.celebratEn(ciutat)
                    && medalla.esDaquestSexe("Women")) {
                return medalla.copia();
            }
        }
        return null;
    }

    // 5. Method to find the country with the most medals of a specified type
    public String paisAmbMesMedalles(String tMedalla) {
        if (numMedalles == 0) {
            return null; // No medals in the list
        }
        String[] paisos = new String[numMedalles];
        int[] count = new int[numMedalles];
        int numPaisos = 0;

        for (int i = 0; i < numMedalles; i++) {
            Medalla medalla = llista[i];
            if (medalla.esTipusMedalla(tMedalla)) {
                String pais = medalla.getPais();
                int index = -1;
                for (int j = 0; j < numPaisos; j++) {
                    if (paisos[j].equalsIgnoreCase(pais)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    paisos[numPaisos] = pais;
                    count[numPaisos] = 1;
                    numPaisos++;
                } else {
                    count[index]++;
                }
            }
        }

        String paisMax = null;
        int maxMedals = 0;
        for (int i = 0; i < numPaisos; i++) {
            if (count[i] > maxMedals) {
                maxMedals = count[i];
                paisMax = paisos[i];
            }
        }
        return paisMax;
    }

    // 6. Method to calculate the medal count of each type won by a specific country
    public int[] medaller(String pais) {
        int[] medalsWon = {0, 0, 0}; // [Gold, Silver, Bronze]
        for (int i = 0; i < numMedalles; i++) {
            Medalla medalla = llista[i];
            if (medalla.getPais().equalsIgnoreCase(pais)) {
                if (medalla.esTipusMedalla("GOLD")) {
                    medalsWon[0]++;
                } else if (medalla.esTipusMedalla("SILVER")) {
                    medalsWon[1]++;
                } else if (medalla.esTipusMedalla("BRONZE")) {
                    medalsWon[2]++;
                }
            }
        }
        return medalsWon;
    }

    // 7. Method to get medals of a specific type and city into a new list
    public LlistaMedalles medallaEnTipusDeProvaIJocs(String prova, String ciutat) {
        LlistaMedalles novaLlista = new LlistaMedalles(numMedalles);
        for (int i = 0; i < numMedalles; i++) {
            if (llista[i].celebratEn(ciutat)
                    && llista[i].esAquestaProva(prova)) {
                novaLlista.afegirMedalla(llista[i].copia());
            }
        }
        return novaLlista;
    }

    // 8. Method to delete all medals of a specific type in a city and year
    public void esborrarMedalles(String ciutat, int any) {
        int i = 0;
        while (i < numMedalles) {
            if (llista[i].celebratAny(any) && llista[i].celebratEn(ciutat)) {
                for (int j = i; j < numMedalles - 1; j++) {
                    llista[j] = llista[j + 1];
                }
                numMedalles--;
            } else {
                i++;
            }
        }
    }

    // 9. Method to delete medals of a specific type in a specified year, city, and type
    public void esborrarMedallesTipus(String ciutat, int any, String tipusProva) {
        int i = 0;
        while (i < numMedalles) {
            if (llista[i].celebratAny(any)
                    && llista[i].celebratEn(ciutat)
                    && llista[i].esAquestaProva(tipusProva)) {
                for (int j = i; j < numMedalles - 1; j++) {
                    llista[j] = llista[j + 1];
                }
                numMedalles--;
            } else {
                i++;
            }
        }
    }

    // 10. Method to delete medals for a specific event in a particular year and city
    public void eliminarMedallesProva(String ciutat, int any, String tipusProva) {
        System.out.println("Medals before deletion:");
        System.out.println(medallaEnTipusDeProvaIJocs(tipusProva, ciutat).toString());

        // Call the delete method to remove the medals
        esborrarMedallesTipus(ciutat, any, tipusProva);

        System.out.println("Medals after deletion:");
        System.out.println(medallaEnTipusDeProvaIJocs(tipusProva, ciutat).toString());
        System.out.println("Number of medals after deletion: " + numMedalles);
    }

    // 11. Method to exit the program (Placeholder for any necessary cleanup or actions)
    public void sortir() {
        System.out.println("Exiting the program. Goodbye!");
        // Any additional cleanup or save actions can be performed here if needed.
    }
    
}
