import java.time.LocalDate;

public class Hafrenspieler extends Musiker{
    private double gewichtHarfeInKg;

    public Hafrenspieler(){
        super();
        setGewichtHarfe(10);
    }

    public Hafrenspieler(LocalDate geburtsDatum, String name, int stunden, float stundenLohnInEuro, double gewichtHarfeInKg) {
        super(geburtsDatum, name, stunden, stundenLohnInEuro);
        setGewichtHarfe(gewichtHarfeInKg);
    }

    public double getGewichtHarfe() {
        return gewichtHarfeInKg;
    }

    public void setGewichtHarfe(double gewichtHarfeInKg) {
        if(gewichtHarfeInKg>0){
            this.gewichtHarfeInKg = gewichtHarfeInKg;
        }else {
            this.gewichtHarfeInKg=10;
        }
    }

    public String toString() {
        return super.toString()+"\nGewicht der Harfe: "+gewichtHarfeInKg+"Kg";
    }

    public double geld() {
        return super.geld()+(gewichtHarfeInKg*50);
    }
}
