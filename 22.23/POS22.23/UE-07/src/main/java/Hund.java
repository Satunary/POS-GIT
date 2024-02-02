public class Hund extends Haustier{
    private String faehigkeiten;

    public Hund(float gewicht, String name, String faehigkeiten){
        super(gewicht, name);
        setFaehigkeiten(faehigkeiten);
    }

    public void setFaehigkeiten(String faehigkeiten) {
        this.faehigkeiten = faehigkeiten;
    }

    public String toString() {
        return super.toString()+", Fähigkeiten: "+faehigkeiten;
    }

    public String geraeuschMachen() {
        return "Wau Wau";
    }
}
