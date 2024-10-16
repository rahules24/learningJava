public class UsaDiccionari {

    public static void main(String[] args) {
        int option;
        Diccionari dictionary = new Diccionari(30);

        addInitialWords(dictionary);
        showMenu();

        option = readInteger();
        while (option != 7) {
            switch (option) {
                case 1:
                    option1(dictionary);
                    break;
                case 2:
                    option2(dictionary);
                    break;
                case 3:
                    option3(dictionary);
                    break;
                case 4:
                    option4(dictionary);
                    break;
                case 5:
                    option5(dictionary);
                    break;
                case 6:
                    option6(dictionary);
                    break;
            }

            showMenu();
            option = readInteger();
        }
    }

    private static void addInitialWords(Diccionari diccio) {
		Paraula p = new Paraula("Vector", "Element d'un espai vectorial amb tantes components com dimensio de l'espai");
		diccio.afegirParaula(p);
		p.setDefinicio("Estructura de dades formada per un conjunt d'elements que son accessibles pel seu index");
		diccio.afegirParaula(p);

		// anem a provar que si afegim una paraula amb la seva definicio repetida, aquesta realment
		// no s'afegeix
		diccio.afegirParaula(p);
		diccio.afegirParaula(p);
		
		diccio.afegirParaula(new Paraula("Arbre", "Estructura de dades no lineal"));
		diccio.afegirParaula(new Paraula("Taula de dispersio", "Estructura de dades no lineal"));
		diccio.afegirParaula(new Paraula("Arbre", "Planta"));
    }


    public static void showMenu() {
        System.out.println("\n\nMenu options:");
        System.out.println("\n\t1. Add a word to the dictionary");
        System.out.println("\t2. Remove a word");
        System.out.println("\t3. Show the contents of the dictionary");
        System.out.println("\t4. Check the number of definitions of a word");
        System.out.println("\t5. Check the i-th definition of a word");
        System.out.println("\t6. Check all definitions of a word");
        System.out.println("\t7. Exit");
        System.out.print("\n\t\t\tChoose an option:\n");
    }

    public static void option1(Diccionari dic) {
        System.out.print("\n\n\tEnter the word name:\t");
        String name = readString();
        System.out.print("\tEnter definition:\t");
        String definition = readString();
        dic.afegirParaula(new Paraula(name, definition));
    }

    public static void option2(Diccionari dic) {
        System.out.print("\n\n\tEnter word:\t");
        String word = readString();
        dic.esborrarParaula(word);
    }

    public static void option3(Diccionari dic) {
        for (int i = 0; i < dic.numParaules(); i++) {
            Paraula p = dic.paraulaIessima(i);
            System.out.println(p.getNom() + ": " + p.getDefinicio(0)); // Display first definition
        }
    }

    public static void option4(Diccionari dic) {
        System.out.print("\n\n\tEnter word:\t");
        String word = readString();
        System.out.println("Number of definitions: " + dic.numDefinicions(word));
    }

    public static void option5(Diccionari dic) {
        System.out.print("\n\n\tEnter word:\t");
        String word = readString();
        System.out.print("\n\n\tEnter definition number to show:\t");
        int position = readInteger();
        System.out.println(dic.getDefinicio(word, position));
    }

    public static void option6(Diccionari dic) {
        System.out.print("\n\n\tEnter the word for which you want to show all its definitions:\t");
        String word = readString();
        int numDefinitions = dic.numDefinicions(word);
        for (int i = 0; i < numDefinitions; i++) {
            System.out.println(dic.getDefinicio(word, i));
        }
    }

    private static String readString() {
        byte[] input = new byte[100];
        try {
            System.in.read(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(input).trim();
    }

    private static int readInteger() {
        String input = readString();
        return Integer.parseInt(input);
    }
}
