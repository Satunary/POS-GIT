import java.time.LocalDate;

public class Arbeiter extends Person{
    private int stunden;
    private double stundenLohn;

    public Arbeiter(String name, LocalDate geburtsDatum, int stunden, double stundenLohn) {
        super(name, geburtsDatum);
        this.stunden = stunden;
        this.stundenLohn = stundenLohn;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        if(stunden<1 || stunden > 40){
            throw new IllegalArgumentException("Stunden müssen zwischen 1 und 40 liegen");
        }
        this.stunden = stunden;
    }

    public double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(double stundenLohn) {
        if (stundenLohn<0){
            throw new IllegalArgumentException("Stundenlohn muss positiv sein");
        }
        this.stundenLohn = stundenLohn;
    }

    @Override
    public String toString() {
        return super.toString()+"\nStunden: "+stunden+"\nStundenlohn: "+stundenLohn;
    }

    @Override
    public double lohn() {
        return stunden*stundenLohn;
    }
}
