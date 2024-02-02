public class EinzelZahl extends Einsatz {
    private int zahl;

    public EinzelZahl(String name, int betrag, int zahl) {
        super(name, betrag);
        setZahl(zahl);
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        if(zahl<0 || zahl>36){
            throw new RouletteExeption("Zahl muss zwischen 0&36 sein");
        }
        this.zahl = zahl;
    }

    public int berechneGewinn(int z){
        if(z==zahl){
            return getBetrag()*35;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString()+", gesetzte Zahl: "+zahl;
    }
}
