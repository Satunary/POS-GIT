import java.time.LocalDate;

public class Polier extends Arbeiter{
    private int anzahlArbeiter;

    public Polier(String name, LocalDate geburtsDatum, int stunden, double stundenLohn, int anzahlArbeiter) {
        super(name, geburtsDatum, stunden, stundenLohn);
       setAnzahlArbeiter(anzahlArbeiter);
    }

    public int getAnzahlArbeiter() {
        return anzahlArbeiter;
    }

    public void setAnzahlArbeiter(int anzahlArbeiter) {
        if(anzahlArbeiter<0){
            throw new IllegalArgumentException("Anzahl Arbeiter darf nicht negativ sein");
        }
        this.anzahlArbeiter = anzahlArbeiter;
    }

    @Override
    public String toString() {
        return super.toString()+"\nAnzahl der beschäftigten Arbeiter: "+anzahlArbeiter;
    }

    @Override
    public double lohn() {
        return super.lohn()+anzahlArbeiter*50;
    }


}
