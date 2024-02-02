public class GeradeUngerade extends Einsatz{
    private boolean gerade;

    public GeradeUngerade(String name, int betrag, boolean gerade) {
        super(name, betrag);
        setGerade(gerade);
    }

    public void setGerade(boolean gerade) {
        this.gerade = gerade;
    }
    public boolean getGerade(){
        return gerade;
    }

    public int berechneGewinn(int z){
        if((z%2==0 && gerade)||(!(z%2==0) && !gerade)){
            return getBetrag()*2;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String s=super.toString()+", gesetzte Zahl: ";
        if(gerade){
            s+="gerade";
        }else {
            s+="ungerade";
        }
        return s;
    }
}
