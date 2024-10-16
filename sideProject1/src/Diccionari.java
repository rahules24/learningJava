public class Diccionari {
    private Paraula[] paraules;
    private int capacitat;
    private int size;

    public Diccionari(int capacitat) {
        this.capacitat = capacitat;
        paraules = new Paraula[capacitat];
        size = 0;
    }

    public boolean afegirParaula(Paraula p) {
        if (size < capacitat && trobarIndexParaula(p.getNom()) == -1) {
            paraules[size] = p;
            size++;
            return true;
        }
        return false;
    }

    public boolean esborrarParaula(String nom) {
        int index = trobarIndexParaula(nom);
        if (index != -1) {
            paraules[index] = paraules[size - 1];
            paraules[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }

    public int numParaules() {
        return size;
    }

    public Paraula paraulaIessima(int index) {
        return (index >= 0 && index < size) ? paraules[index] : null;
    }

    public int numDefinicions(String nom) {
        Paraula p = obtenirParaula(nom);
        return (p != null) ? p.numDefinicions() : 0;
    }

    public String getDefinicio(String nom, int index) {
        Paraula p = obtenirParaula(nom);
        return (p != null && index < p.numDefinicions()) ? p.getDefinicio(index) : null;
    }

    private int trobarIndexParaula(String nom) {
        for (int i = 0; i < size; i++) {
            if (paraules[i].getNom().equals(nom)) {
                return i;
            }
        }
        return -1;
    }

    private Paraula obtenirParaula(String nom) {
        int index = trobarIndexParaula(nom);
        return (index != -1) ? paraules[index] : null;
    }
}
