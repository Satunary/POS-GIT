import java.util.*;

public class Orchester {
    private ArrayList<Kuenstler> kuenstlers=new ArrayList<>();

    public Orchester(){

    }
    public void einfügen(Kuenstler k){
        kuenstlers.add(k);
    }
    public void entfernen(Kuenstler k){
        kuenstlers.remove(k);
    }

    public Kuenstler[] aelteste(int anzahl){
        ArrayList<Kuenstler> kListTemp  =new ArrayList<>();
        Kuenstler[] kList = new Kuenstler[anzahl];
        Kuenstler k0 =kuenstlers.get(0);


        for(int i=0; i<anzahl;i++){
            k0=kuenstlers.get(i);
            for(int y=i+1;y<kuenstlers.size();y++){
                if(k0.getGeburtsDatum().compareTo(kuenstlers.get(y).getGeburtsDatum())>=0&& ! kListTemp.contains(kuenstlers.get(y))){
                    //wenn man das kListTemp.contains hier als loop prüfung eingebaut hätte wäre das Programm effectiefer aber länger
                    k0=kuenstlers.get(y);
                }
            }
            kList[i]=k0;
        }
        return  kList;
    }

    public String toString(){
        String s=kuenstlers.get(0).toString()+"\n----------------------";
        for(int i=1;i<kuenstlers.size();i++){
            s+="\n"+kuenstlers.get(i).toString()+"\n----------------------";
        }
        return s;
    }

    public void print(){
        System.out.println(toString());
    }

    public double geld(){
        double geld=0;
        for(int i=0;i<kuenstlers.size();i++){
            geld+=kuenstlers.get(i).geld();
        }
        return geld;
    }
}
