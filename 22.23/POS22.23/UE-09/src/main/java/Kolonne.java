public class Kolonne extends Dutzend{

    public Kolonne(String name, int betrag, int zahl) {
        super(name, betrag, zahl);
    }


    public int berechneGewinn(int z) {
        while (z>3){
            z-=3;
        }
        if(getZahl()==z){
            return getBetrag()*3;
        }
        return 0;
    }

    public String toString(){
        return "Name: "+getName()+", Betrag: "+getBetrag()+", Kolonne: "+getZahl();
    }
}
