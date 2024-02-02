import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private LocalDate gebDatum;

    public Person(String name, LocalDate gebDatum) {
        this.gebDatum = gebDatum;
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    // Vergleichen nach dem Namen.
    // 0 ... this + other ist gleich
    // <0 ... this < other
    // >0 ... this > other
    @Override
    public int compareTo(Person other) {
        // Kurze Loesung:
        // return name.compareTo(other.name);

        // 1. Objekt: this
        Person a = this;
        // 2. Objekt: other
        Person b = other;

        // Es gibt fast immer eine compareTo-Methode bei vordefinierten Typen wie: String, LocalDate, ...
        // int, double usw. kann man mit Integer.compare(...), Double.compare(...), usw. vergleichen.
        int result = b.name.compareTo(a.name);
        return result;
    }

    public LocalDate getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(LocalDate gebDatum) {
        this.gebDatum = gebDatum;
    }
}