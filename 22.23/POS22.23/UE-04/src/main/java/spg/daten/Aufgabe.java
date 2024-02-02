package spg.daten;
import java.util.Random;

public class Aufgabe {
    private String gegenstand;
    private String aufwand;
    private static String[] gegenstaende=new String[] {"Englisch", "Deutsch", "Mathe", "POS", "Geschichte", "Biologie", "Geographie", "Chemie", "Physik"};

    public Aufgabe(String gegenstand, String aufwand){
        setAufwand(aufwand);
        setGegenstand(gegenstand);
    }

    public void setAufwand(String aufwand) {
        Random r=new Random();
        try{
            String[] s=aufwand.split(":");
            String s1 = s[0];
            String s2=s[1];
            int i=Integer.parseInt(s1);
            int i1=Integer.parseInt(s2);
            if(i<6 && i>=0 && i1<60 && i1>=0 && s1.length()==2 && s2.length()==2){
                this.aufwand=aufwand;
            }else{
                System.out.println("Nicht gültig");
                this.aufwand="0"+r.nextInt(6)+":";
                int i2=r.nextInt(60);
                if(i2<10){this.aufwand+="0"+i2;}
                else {this.aufwand+=i2;}
            }
        }catch (Exception exception){
            System.out.println("Nicht gültig");
            this.aufwand="0"+r.nextInt(6)+":";
            int i2=r.nextInt(60);
            if(i2<10){this.aufwand+="0"+i2;}
            else {this.aufwand+=i2;}
        }


    }
    public void setGegenstand(String gegenstand) {
        for(int i=0;i<gegenstaende.length;i++){
            if(gegenstaende[i].equals(gegenstand)){
                this.gegenstand = gegenstand;
                return;
            }
        }
        this.gegenstand = "POS";
    }

    public String getGegenstand() {
        return gegenstand;
    }

    public String getAufwand() {
        return aufwand;
    }

    public String toString() {
        String s1=gegenstand.substring(0,3).toUpperCase();
        String s=gegenstand+" ("+s1+") Aufgabe Zeitaufwand ca. "+aufwand;
        return s;
    }
}
