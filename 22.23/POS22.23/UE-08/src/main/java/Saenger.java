import java.time.LocalDate;

public class Saenger extends Kuenstler{
    private boolean opernSaenger;
    private int anzahlAuftritte;
    private double gage;

    public Saenger(){

    }

    public Saenger(LocalDate geburtsDatum, String name, boolean opernSaenger, int anzahlAuftritte, double gage) {
        super(geburtsDatum, name);
        setOpernSaenger(opernSaenger);
        setAnzahlAuftritte(anzahlAuftritte);
        setGage(gage);
    }

    public boolean isOpernSaenger() {
        return opernSaenger;
    }

    public void setOpernSaenger(boolean opernSaenger) {
        this.opernSaenger = opernSaenger;
    }

    public int getAnzahlAuftritte() {
        return anzahlAuftritte;
    }

    public void setAnzahlAuftritte(int anzahlAuftritte) {
        if(anzahlAuftritte>0) {
            this.anzahlAuftritte = anzahlAuftritte;
        }else {
            this.anzahlAuftritte=0;
        }
    }

    public double getGage() {
        return gage;
    }

    public void setGage(double gage) {
        if(gage>0) {
            this.gage = gage;
        }else{
            this.gage=20f;
        }
    }

    @Override
    public String toString() {
        String s="";
        if(opernSaenger){
            s+="\nist ein/e OpernsängerIn";
        }else {
            s+="\nist kein/e OpernsängerIn";
        }
        return super.toString()+s+"\n anzahl Auftritte: "+anzahlAuftritte+"\n Gage: "+gage;
    }

    public double geld(){
        if(opernSaenger){
            return anzahlAuftritte*gage*2;
        }
        return anzahlAuftritte*gage;
    }
}
