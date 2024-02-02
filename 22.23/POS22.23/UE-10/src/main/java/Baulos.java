import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Baulos {
    private ArrayList<Person> beschaeftigte;
    private String kennung;
    private String firma;
    private LocalDate startDatum;
    private LocalDate endDatum;

    public Baulos(String kennung, String firma, LocalDate startDatum, LocalDate endDatum) {
        beschaeftigte = new ArrayList<>();
        setKennung(kennung);
        setFirma(firma);
        setStartDatum(startDatum);
        setEndDatum(endDatum);
    }

    public String getKennung() {
        return kennung;
    }

    public void setKennung(String kennung) {
        if (kennung.equals(null)) {
            throw new IllegalArgumentException("Kennung ungültig");
        }
        this.kennung = kennung;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        if (firma.equals(null)) {
            throw new IllegalArgumentException("Firma ungültig");
        }
        this.firma = firma;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        if (startDatum == null) {
            throw new IllegalArgumentException("Startdatum ungültig");
        }
        this.startDatum = startDatum;
    }

    public LocalDate getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDate endDatum) {
        if (endDatum == null || endDatum.isBefore(startDatum) || endDatum.isEqual(startDatum)) {
            throw new IllegalArgumentException("Enddatum ungültig");
        }
        this.endDatum = endDatum;
    }

    public void zuteilen(Person p) {
        if (beschaeftigte.contains(p)) {
            throw new IllegalArgumentException("Personen dürfen nur einmal existieren");
        }
        beschaeftigte.add(p);
    }

    public void abziehen(String s) {
        for (int i = 0; i < beschaeftigte.size(); i++) {
            if (beschaeftigte.get(i).getName().equals(s)) {
                beschaeftigte.remove(i);
            }
        }
    }

    public void abziehen(double d) {
        for (int i = 0; i < beschaeftigte.size(); i++) {
            if (beschaeftigte.get(i).lohn() > d) {
                beschaeftigte.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String s = "Firma: " + firma + "\nKennung: " + kennung + "\nStartdatum: " + startDatum.toString() + "\ngeplantes Enddatum: " + endDatum.toString();
        for (int i = 0; i < beschaeftigte.size(); i++) {
            s += "\n---------------------\nBeschäftigter "+(i+1)+"\n" + beschaeftigte.get(i).toString();
        }
        return s;
    }

    public double kosten() {
        double erg = 0;
        for (int i = 0; i < beschaeftigte.size(); i++) {
            erg += beschaeftigte.get(i).lohn();
        }
        return erg;
    }

    public void print() {
        System.out.println(toString());
    }


}
