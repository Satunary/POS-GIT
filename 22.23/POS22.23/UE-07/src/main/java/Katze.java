public class Katze extends Haustier{
    private String farbe;

    public Katze(float gewicht,String name, String farbe){
        super(gewicht, name);
        setFarbe(farbe);
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String toString() {
        return super.toString()+", Fell farbe: "+farbe;
    }

    public String geraeuschMachen() {
        return "Miau";
    }
}
