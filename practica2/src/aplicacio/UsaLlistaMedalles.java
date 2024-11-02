package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

public class UsaLlistaMedalles {
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter the number of lines to read from the file (maximum 21694)");
        int numLinies = Integer.parseInt(teclat.nextLine());
        
        // Read data from the file and store in a dataset
        String[] dataset = llegirLiniesFitxer(numLinies);

        // Initialize LlistaMedalles to store all medal data
        LlistaMedalles llistaMedalles = new LlistaMedalles(numLinies);

        // Parse each line of the dataset and create Medalla objects
        for (String line : dataset) {
            String[] fields = line.split(";");
            
            // Split the city and year from the slug_game field (assume it's in the format "city-year")
            String[] cityYear = fields[1].split("-");
            String city = cityYear[0];  // city part (e.g., "beijing")
            int year = Integer.parseInt(cityYear[1]);  // year part (e.g., "2022")

            Medalla medalla = new Medalla(
                fields[0],          // discipline
                city,               // city (from slug_game)
                year,               // year (from slug_game)
                fields[2],          // event
                fields[3],          // gender
                fields[4],          // medal type
                fields[5],          // participation type
                fields[6]           // country
            );
            llistaMedalles.afegirMedalla(medalla);
        }

        // Display the menu and interact with the user
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show the dataset");
            System.out.println("2. Number of medals won by a country in a year and city");
            System.out.println("3. First medal matching type, gender, and year");
            System.out.println("4. First medal won by a woman in a year and city");
            System.out.println("5. Country with the most medals of a type");
            System.out.println("6. Medal count for a country");
            System.out.println("7. Medals in a specific event and city");
            System.out.println("8. Delete medals by city and year");
            System.out.println("9. Delete medals by city, year, and event type");
            System.out.println("10. Delete and display verification for specific event, year, and city");
            System.out.println("11. Exit");

            int choice = Integer.parseInt(teclat.nextLine());

            switch (choice) {
                case 1:
                    System.out.println(llistaMedalles.toString());
                    break;
                case 2:
                    System.out.println("Enter city, year, medal type, and country initials:");
                    String city = teclat.nextLine();
                    int year = Integer.parseInt(teclat.nextLine());
                    String medalType = teclat.nextLine();
                    String country = teclat.nextLine();
                    System.out.println("Medals: " + llistaMedalles.medallesPais(city, year, medalType, country));
                    break;
                case 3:
                    System.out.println("Enter medal type, gender, and year:");
                    medalType = teclat.nextLine();
                    String gender = teclat.nextLine();
                    year = Integer.parseInt(teclat.nextLine());
                    System.out.println("First matching medal: " + llistaMedalles.cercaPrimeraMedalla(medalType, gender, year));
                    break;
                case 4:
                    System.out.println("Enter year and city:");
                    year = Integer.parseInt(teclat.nextLine());
                    city = teclat.nextLine();
                    System.out.println("First woman’s medal: " + llistaMedalles.primeraMedallaDona(year, city));
                    break;
                case 5:
                    System.out.println("Enter medal type:");
                    medalType = teclat.nextLine();
                    System.out.println("Country with most medals: " + llistaMedalles.paisAmbMesMedalles(medalType));
                    break;
                case 6:
                    System.out.println("Enter country initials:");
                    country = teclat.nextLine();
                    int[] medalCount = llistaMedalles.medaller(country);
                    System.out.println("Gold: " + medalCount[0] + ", Silver: " + medalCount[1] + ", Bronze: " + medalCount[2]);
                    break;
                case 7:
                    System.out.println("Enter event and city:");
                    String event = teclat.nextLine();
                    city = teclat.nextLine();
                    System.out.println("Medals in event and city: " + llistaMedalles.medallaEnTipusDeProvaIJocs(event, city));
                    break;
                case 8:
                    System.out.println("Enter city and year:");
                    city = teclat.nextLine();
                    year = Integer.parseInt(teclat.nextLine());
                    llistaMedalles.esborrarMedalles(city, year);
                    System.out.println("Medals deleted for specified city and year.");
                    break;
                case 9:
                    System.out.println("Enter city, year, and event type:");
                    city = teclat.nextLine();
                    year = Integer.parseInt(teclat.nextLine());
                    event = teclat.nextLine();
                    llistaMedalles.esborrarMedallesTipus(city, year, event);
                    System.out.println("Medals deleted for specified city, year, and event.");
                    break;
                case 10:
                    System.out.println("Enter city, year, and event type for deletion and verification:");
                    city = teclat.nextLine();
                    year = Integer.parseInt(teclat.nextLine());
                    event = teclat.nextLine();
                    llistaMedalles.eliminarMedallesProva(city, year, event);  // Call to Function #10
                    break;
                case 11:
                    llistaMedalles.sortir();  // Directly call sortir() for function #11
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to read lines from a file and return them as an array of strings
    private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
        String[] result;
        if (nLinies < 0)
            nLinies = 0;
        if (nLinies > 21694)
            nLinies = 21694;
        result = new String[nLinies];
        Scanner f = new Scanner(new File("../olympic_medals_part_UTF8.csv"));

        String header = f.nextLine();
        System.out.println("The data format for each line is as follows\n" + header);
        for (int i = 0; i < nLinies; i++) {
            result[i] = f.nextLine();
        }
        f.close();
        return result;
    }
}
