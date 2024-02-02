import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Weinberg {
    private String name;
    private ArrayList<Stock> a = new ArrayList<>();
    private double groesseInHa;

    public void setGroesseInHa(double groesseInHa) {
        this.groesseInHa = groesseInHa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weinberg(String name,double groesseInHa){
        setName(name);
        setGroesseInHa(groesseInHa);
    }
    public void setztenEnde(Stock s){
        if(!(a.contains(s))&&s!=null){
            a.add(s);
        }else {
            throw new IllegalArgumentException("Keine doppelten Elemente und keine null Elemente");
        }
    }
    public boolean setzenAnfang(Stock s){
        if(!(a.contains(s))&&s!=null){
            a.add(0,s);
            return true;
        }else {
            return false;
        }
    }
    public void entfernen(Stock s){
        a.remove(s);
    }
    public ArrayList<Stock> entfernenAlle(){
        ArrayList<Stock> a0 =new ArrayList<>();
        for(int i=0;i<a.size();i++){
            if(a.get(i).getKrank()){
                a0.add(a.get(i));
                a.remove(i);
            }
        }
        return a0;
    }
    public int anzahlKrank(){
        int x=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getKrank()){
                x++;
            }
        }
        return x;
    }
    public double ertrag(){
        double x=0;
        for(int i=0;i<a.size();i++){
            x+=a.get(i).getErtrag();
        }
        return x/groesseInHa;
    }
    public void sortieren(){
        Stock s0;
        for(int i=0;i<a.size();i++){
            s0=a.get(i);
            for(int y=i;y<a.size();y++){
                if(s0.getSetztDatum().isBefore(a.get(y).getSetztDatum())){
                    s0=a.get(y);
                }
            }
            a.add(i,s0);
        }
    }
    public int anzahlStoecke(){
        return a.size();
    }
    public void print(){
        String s="Name: "+name+"\n"+"Hektar: "+groesseInHa+"\n";
        for(int i=0; i<a.size();i++){
            s+="Stock NR: "+i+"\n";
            s+=a.get(i).toString();
            s+="\n";
        }
        System.out.print(s);
    }
    public void printGruppiert(){
        ArrayList<String> s=new ArrayList<String>();
        for (int i=0;i<a.size();i++){
            if(!(s.contains(a.get(i).getSorte()))){
                s.add(a.get(i).getSorte());
            }
        }
        double[] i=new double[s.size()];
        for(int y=0;y<a.size();y++){
            i[s.indexOf(a.get(y).getSorte())]+=a.get(y).getErtrag();
        }
        //Print
        String s0="";
        for(int y=0;y<s.size();y++){
            s0+="Sorte: "+s.get(y)+", "+i[y]+"\n";
        }
        System.out.println(s0);
    }
}
