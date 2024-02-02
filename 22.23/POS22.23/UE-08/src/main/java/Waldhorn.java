import java.time.LocalDate;

public class Waldhorn extends Musiker{
    private int richtigGespielt;
    private int falschGeschpielt;

    public Waldhorn (){
        super();

    }

    public Waldhorn(LocalDate geburtsDatum, String name, int stunden, float stundenLohnInEuro) {
        super(geburtsDatum, name, stunden, stundenLohnInEuro);
    }

    public int getRichtigGespielt() {
        return richtigGespielt;
    }

    public void setRichtigGespielt(int richtigGespielt) {
        if(richtigGespielt>0 && richtigGespielt>this.richtigGespielt){
            this.richtigGespielt = richtigGespielt;
        }
    }
    public void setRichtigGespieltNull(){
        this.richtigGespielt=0;
    }

    public int getFalschGeschpielt() {
        return falschGeschpielt;
    }

    public void setFalschGeschpielt(int falschGeschpielt) {
        if(falschGeschpielt>0 && falschGeschpielt>this.falschGeschpielt){
            this.falschGeschpielt = falschGeschpielt;
        }
    }
    public void setFalschGespieltNull(){
        this.falschGeschpielt=0;
    }

    @Override
    public String toString() {
        return super.toString()+"\nrichtig gespielte Noten: "+richtigGespielt+"\nfalsch gespielte Noten: "+falschGeschpielt;
    }

    @Override
    public double geld() {
        return super.geld()+(richtigGespielt*10)-(falschGeschpielt*5);
    }
}
