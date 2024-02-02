import java.time.LocalDate;

public class Stock {
    private String sorte;
    private LocalDate setztDatum;
    private boolean krank;
    private double ertrag;

    public void setErtrag(double ertrag) {
        if(ertrag<=0||ertrag>4){
            throw new IllegalArgumentException("Ertrag muss zwischen 0 und 5l liegen");
        }
        this.ertrag = ertrag;
    }

    public void setSetztDatum(LocalDate setztDatum) {
        this.setztDatum = setztDatum;
    }

    public void setSorte(String sorte) {
        if(sorte.length()<3){
            throw new IllegalArgumentException("Sortenname muss länger als 2 Zeichen sein");
        }
        this.sorte = sorte;
    }

    public void setKrank(boolean krank) {
        this.krank = krank;
    }

    public Stock(String sorte, LocalDate setztDatum, double ertrag,boolean krank){
        setErtrag(ertrag);
        setSorte(sorte);
        setSetztDatum(setztDatum);
        setKrank(krank);
    }

    public boolean getKrank() {
        return krank;
    }

    public double getErtrag() {
        return ertrag;
    }

    public LocalDate getSetztDatum() {
        return setztDatum;
    }

    public String getSorte() {
        return sorte;
    }

    public String toString(){
        String s="Sorte: "+sorte+"| "+"Ertrag: "+ertrag+"| "+setztDatum.toString();
        if(krank){
            s+="| ist Krank";
        }else {
            s+="| ist nicht Krank";
        }
        return s;
    }
}

