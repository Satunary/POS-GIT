import java.util.ArrayList;
import java.util.Collections;

public class Verein {
    private final String name;
    private ArrayList<Person> personen;

    public Verein(String name) {
        this.name = name;
        personen = new ArrayList<>();
    }

    public void add(Person p) {
        personen.add(p);
    }

    public void print() {
        for (Person p: personen) {
            System.out.println(p);
        }
    }

    public void sortierenNachNamen() {
        Collections.sort(personen);
    }
}
