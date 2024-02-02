import java.util.Comparator;

public class CompareBetrag implements Comparator<Einsatz> {
    @Override
    public int compare(Einsatz o1, Einsatz o2) {
        return Integer.compare(o1.getBetrag(), o2.getBetrag());
    }
}
