import java.util.Collection;
import java.util.Collections;

public abstract class Einsatz implements Comparable<Einsatz>{
    private String name;
    private int betrag;

    public int compareTo(Einsatz o) {

        if(betrag> o.betrag){
            return -1;
        }if(betrag==o.betrag){
            return 0;
        }else {
            return 1;
        }
    }

    public Einsatz(String name, int betrag) {
        setName(name);
        setBetrag(betrag);
    }

    public Einsatz() {
        setBetrag(5);
        setName("Default");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBetrag() {
        return betrag;
    }

    public void setBetrag(int betrag) throws RouletteExeption {
        if (betrag<5 || betrag>100) {
            throw new RouletteExeption("Einsatz unter null");
        }
        this.betrag = betrag;
    }

    public abstract int berechneGewinn(int z);

    public String toString(){
        return "Name: "+name+", Betrag: "+betrag;
    }
}


