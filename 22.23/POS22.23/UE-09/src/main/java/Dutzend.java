public class Dutzend extends Einsatz{
    private int zahl;

    public Dutzend(String name, int betrag, int zahl) {
        super(name, betrag);
        setZahl(zahl);
    }

    public Dutzend(){
        super();
        setZahl(1);
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        if(zahl<1||zahl>3){
            throw new RouletteExeption("Zahl darf nur von 1-3 gehen");
        }
        this.zahl = zahl;
    }

    public int berechneGewinn(int z) {
        if(z>0&&z<13){
            z=1;
        }if(z>12&&z<25){
            z=2;
        }if(z>24){
            z=3;
        }
        if(zahl==z){
            return getBetrag()*3;
        }
        return 0;
    }

    public String toString() {
        return super.toString()+", Drittel: "+zahl;
    }
}
