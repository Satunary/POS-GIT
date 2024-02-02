package at.spenger;

import java.time.LocalDate;
import java.util.Objects;

public class Lied {
    private String titel;
    private String interpret;
    private long laengeInS;
    private LocalDate erscheinungsDatum;

    public Lied(String titel, String interpret, long laengeInS, LocalDate erscheinungsDatum) {
        setTitel(titel);
        setInterpret(interpret);
        setLaengeInS(laengeInS);
        setErscheinungsDatum(erscheinungsDatum);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lied lied = (Lied) o;
        return laengeInS == lied.laengeInS && Objects.equals(titel, lied.titel) && Objects.equals(interpret, lied.interpret) && Objects.equals(erscheinungsDatum, lied.erscheinungsDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, interpret, laengeInS, erscheinungsDatum);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if(titel==null || titel.isBlank()){
            throw new IllegalArgumentException("titel is wrong");
        }
        this.titel = titel;
    }



    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public long getLaengeInS() {
        return laengeInS;
    }

    public void setLaengeInS(long laengeInS) {
        this.laengeInS = laengeInS;
    }

    public LocalDate getErscheinungsDatum() {
        return erscheinungsDatum;
    }

    public void setErscheinungsDatum(LocalDate erscheinungsDatum) {
        this.erscheinungsDatum = erscheinungsDatum;
    }
}
