import java.util.ArrayList;
public class Schulklasse {
    private String name;
    private final ArrayList <Schueler> schueler= new ArrayList<>();

    private void fill(){
        Schueler s=null;
        for(int i=0;i<schueler.size();i++){
            if(schueler.get(i)==null){
                for(int y=i; y<schueler.size();y++){
                    s=schueler.get(y+1);
                    schueler.set(y,s);
                }
                i--;
            }
        }
    }

    public Schulklasse(String name){
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int find(Schueler s){
        return schueler.indexOf(s);
    }
    public boolean einfuegen(Schueler s){
        if(s!=null && !schueler.contains(s)){
            schueler.add(s);
            return true;
        }else{return false;}
    }
    public Schueler entfernen(int index)
    {
        Schueler s =schueler.get(index);
        schueler.remove(index);
        fill();
        return s;
    }

    public String toString(){
        String s=name;
        fill();
        for(int i=0; i< schueler.size();i++){
            int y=i+1;
            s+=" Schüler "+y+"| ";
            s+= schueler.get(i).toString();
            s+="|";
        }
        return s;
    }
}
