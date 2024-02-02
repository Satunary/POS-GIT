import java.util.Comparator;

public class CompareName implements Comparator<Einsatz> {
    @Override
    public int compare(Einsatz o1, Einsatz o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
