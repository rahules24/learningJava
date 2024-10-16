import java.util.ArrayList;

public class Paraula {
    private String nom;
    private ArrayList<String> definicions;

    public Paraula(String n, String def) {
        nom = n;
        definicions = new ArrayList<>();
        definicions.add(def);
    }

    public String getNom() {
        return nom;
    }

    public String getDefinicio(int index) {
        return definicions.get(index);
    }

    public void setDefinicio(String def) {
        if (!definicions.contains(def)) {
            definicions.add(def);
        }
    }

    public ArrayList<String> getDefinicions() {
        return definicions;
    }

    public boolean esAquestaParaula(String n) {
        return nom.equalsIgnoreCase(n);
    }

    public int numDefinicions() {
        return definicions.size();
    }

    @Override
    public String toString() {
        return "PARAULA => Nom:\t" + nom + "\tDefinicions:\t" + definicions;
    }
}

