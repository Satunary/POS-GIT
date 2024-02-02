
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Spiel {
    private LinkedList<Einsatz> einsaetze;
    private int einsaetzeZ;
    private int gewinnZahl;
    private LocalTime zeit;

    public static void main(String[] args) {
        Spiel s=new Spiel();
        s.setzten(new EinzelZahl("Paul",50,30));
        s.setzten(new Dutzend("Tim",30,3));
        s.setzten(new GeradeUngerade("Simon",10,false));
        s.setzten(new Kolonne("Laurenz",100,1));

        s.kugelWerfen();

        System.out.println("Gewürfelter wert: "+s.getGewinnZahl());
        System.out.println(s.gewinnListe());
        System.out.println("Gewinn für das Casino: "+s.berechneErtrag()+"€");
    }

    public Spiel(){
        einsaetze = new LinkedList<>();
        setGewinnZahl(255);
        setZeit(LocalTime.now());
    }

    public Spiel(LinkedList<Einsatz> einsaetze, LocalTime zeit) {
        this.einsaetze = einsaetze;
        this.zeit = zeit;
    }

    public int getEinsaetzeZ() {
        return einsaetzeZ;
    }

    public void setEinsaetzeZ(int einsaetzeZ) {
        this.einsaetzeZ = einsaetzeZ;
    }

    public int getGewinnZahl() {
        return gewinnZahl;
    }

    private void setGewinnZahl(int gewinnZahl) {
        this.gewinnZahl = gewinnZahl;
    }


    public LocalTime getZeit() {
        return zeit;
    }

    public void setZeit(LocalTime zeit) {
        this.zeit = zeit;
    }

    public void setzten(Einsatz es){
        if(gewinnZahl!=255||einsaetzeZ>100||einsaetze.contains(es)){
            throw new RouletteExeption("Nicht gültig");
        }
        einsaetze.add(es);
    }

    public void kugelWerfen(){
        if(gewinnZahl!=255){
            throw new RouletteExeption("Gewinnzahl ist Schon gesetzt");
        }
        Random r=new Random();
        gewinnZahl=r.nextInt(37);
    }

    public String gewinnListe(){
        if(gewinnZahl==255&&einsaetze.size()>0){
            throw new RouletteExeption("Gewinnzahl muss gewürfelt sein und es müssen einsätze vorhanden sein");
        }
        String s="Gewinn Liste:\n-----------------------------------------------------------------";
        for(int i=0;i<einsaetze.size();i++){
            s+="\n"+einsaetze.get(i).toString()+", Gewinn: "+einsaetze.get(i).berechneGewinn(gewinnZahl);
        }
        return s;
    }

    public int berechneErtrag(){
        int einsatzSum=0;
        int gewinnSum=0;

        for(int i=0;i<einsaetze.size();i++){
            einsatzSum+=einsaetze.get(i).getBetrag();
            gewinnSum+=einsaetze.get(i).berechneGewinn(gewinnZahl);
        }
        return einsatzSum-gewinnSum;
    }

    public int entfernen(String name){
        int x=0;
        for(int i=0;i<einsaetze.size();i++){
            if(einsaetze.get(i).getName().equals(name)){
                einsaetze.remove(i);
                i--;
                x++;
            }
        }
        return x;
    }

    public boolean entfernen(Einsatz es){
        return einsaetze.remove(es);
    }

    public void sortieren(){
        Collections.sort(einsaetze);
    }

    public void sortierenBetrag(){
        CompareBetrag cb = new CompareBetrag();
        Collections.sort(einsaetze,cb);
    }

    public void sortierenName(){
        CompareName cn = new CompareName();
        Collections.sort(einsaetze,cn);
    }


}
