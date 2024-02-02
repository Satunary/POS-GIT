import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class Bauvorhaben {
    private HashMap<String, Baulos> baulose;

    public Bauvorhaben() {
        baulose =new HashMap<>();
    }

    public void einfuegen(Baulos b){
        baulose.put(b.getKennung(),b);
    }

    public void entfernen(Baulos b){
        baulose.remove(b.getKennung());
    }

    public double kosten(){
        double erg=0;
        for (String s : baulose.keySet()){
            erg+=baulose.get(s).kosten();
        }
        return erg;
    }

    public int anzahlOffen(){
        int erg=0;
        for (String s : baulose.keySet()){
            if(baulose.get(s).getEndDatum().isAfter(LocalDate.now())){
                erg++;
            }
        }
        return erg;
    }

    public void print(){
        int i=1;
        String erg="";
        for (String s : baulose.keySet()){
            erg+="\nBaulos "+i+"\n"+baulose.get(s).toString();
        }
        System.out.println(erg);
    }
}
