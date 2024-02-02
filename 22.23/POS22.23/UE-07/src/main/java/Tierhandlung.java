import java.util.ArrayList;

public class Tierhandlung {
    ArrayList<Haustier> tiere=new ArrayList<>();

    public Tierhandlung(){}
    public void einfuegen(Haustier t){
        tiere.add(t);
    }
    public void entfernen(Haustier t){
        tiere.remove(t);
    }
    public int anzahl(){
        return tiere.size();
    }
    public void gerauscheMachen(){
        for(int i=0;i< tiere.size();i++){
            System.out.println(tiere.get(i).geraeuschMachen());
        }
    }
    public void print(){
        String s="";
        for(int i=0;i< tiere.size();i++){
            s+=tiere.get(i).toString()+"\n";
        }
        System.out.println(s);
    }


    public int anzahlAn(Haustier t){
        // gibt die Anzahl an Haustieren der gegebenen Spezies zurück
        int x=0;
        for(int i=0;i< tiere.size();i++){
            if(tiere.get(i).getClass().equals(t.getClass())){
                x++;
            }
        }
        return x;
    }
}
