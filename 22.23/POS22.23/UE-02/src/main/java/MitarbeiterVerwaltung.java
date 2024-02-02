import java.util.ArrayList;
import java.util.Random;

public class MitarbeiterVerwaltung {
    private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();

    public MitarbeiterVerwaltung() {

    }

    public boolean delMitarbeiter(Mitarbeiter m) {

        return mitarbeiter.remove(m);
    }

    public void addMitarbeiter(Mitarbeiter m) {
        if (!(mitarbeiter.contains(m))) {
            mitarbeiter.add(m);
        } else {
            throw new IllegalArgumentException("Mitarbeiter kann nur einmal existieren");
        }
    }

    public float gesamtUmsatz() {
        float u = 0;
        for (int i = 0; i < mitarbeiter.size(); i++) {
            u += mitarbeiter.get(i).getUmsatz();
        }
        return u;
    }

    public void setUmsaetze(float wert) {
        Random r = new Random();
        int[] mem = new int[mitarbeiter.size()];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = i;
        }
        for (int i = mitarbeiter.size() / 2; i > 0; i--) {
            int y = r.nextInt(mitarbeiter.size());
            if (mem[y] == -1) {
                i++;
                continue;
            }
            mitarbeiter.get(mem[y]).setUmsatz(mitarbeiter.get(mem[y]).getUmsatz() + wert);
            mem[y] = -1;
        }
    }

    public String toString() {
        String ret = mitarbeiter.get(0).toString() + "\n";
        for (int i = 1; i < mitarbeiter.size(); i++) {
            ret += mitarbeiter.get(i).toString() + "\n";
        }
        return ret;
    }

}
