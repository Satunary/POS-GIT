import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

    public abstract class Kuenstler {
    private LocalDate geburtsDatum;
    private String name;

    public Kuenstler(LocalDate geburtsDatum, String name) {
        setGeburtsDatum(geburtsDatum);
        setName(name);
    }
    public Kuenstler(){
        setGeburtsDatum(LocalDate.of(2000,1,1));
        setName("Filler");
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(name=="null"){
            this.name="Anonym";
        }
    }

    public String toString(){
        return "Name: "+name+"\nGeburts Datum: "+geburtsDatum.format(DateTimeFormatter.ofPattern("dd MM yyyy"));
    }

    public void print(){
        System.out.println(toString());
    }

    public abstract double geld();
}
