import java.time.LocalDate;

public class Musiker extends Kuenstler{
    private int stunden;
    private double stundenLohnInEuro;

    public Musiker (){
        super();
        setStunden(35);
        setStundenLohnInEuro(15.0f);
    }

    public Musiker(LocalDate geburtsDatum, String name, int stunden, float stundenLohnInEuro) {
        super(geburtsDatum, name);
        setStunden(stunden);
        setStundenLohnInEuro(stundenLohnInEuro);
    }

    public Musiker(int stunden, float stundenLohnInEuro) {
        this.stunden = stunden;
        this.stundenLohnInEuro = stundenLohnInEuro;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        if(stunden >0) {
            this.stunden = stunden;
        }
    }

    public double getStundenLohnInEuro() {
        return stundenLohnInEuro;
    }

    public void setStundenLohnInEuro(float stundenLohnInEuro) {
        if(stundenLohnInEuro>0) {
            this.stundenLohnInEuro = stundenLohnInEuro;
        }else{
            this.stundenLohnInEuro=15f;
        }
    }

    public String toString(){
        return super.toString()+"\nStunden: "+stunden+"\nStundenlohn: "+stundenLohnInEuro+"€";
    }

    public double geld(){
        return stunden*stundenLohnInEuro;
    }

}
