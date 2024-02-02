import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Messwert {
    private LocalDate datum;
    private double temperatur;
    private double windstaerke;

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        if(LocalDate.now().isBefore(datum.minusWeeks(1))){
            throw new WetterExeption("DATUM");
        }
        this.datum = datum;
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        if(temperatur>65 && temperatur <-90){
            throw new WetterExeption("MESSDATEN");
        }
        this.temperatur = temperatur;
    }

    public double getWindstaerke() {
        return windstaerke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messwert messwert = (Messwert) o;
        return Objects.equals(datum, messwert.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datum);
    }

    public void setWindstaerke(double windstaerke) {
        if (windstaerke<0||windstaerke>12){
            throw new WetterExeption("MESSDATEN");
        }
        this.windstaerke = windstaerke;
    }

    public Messwert(LocalDate datum, double temperatur, double windstaerke) {
        setDatum(datum);
        setTemperatur(temperatur);
        setWindstaerke(windstaerke);
    }

    public static Messwert getMesswert(String s){
        String[] sArray = s.split(":");
        return new Messwert(LocalDate.of(Integer.parseInt(sArray[0].substring(6,9)),Integer.parseInt(sArray[0].substring(3,5)),Integer.parseInt(sArray[0].substring(0,2))),Double.parseDouble(sArray[1]),Double.parseDouble(sArray[2]));
    }

    @Override
    public String toString() {
        return datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+":"+temperatur+":"+windstaerke;
    }

}
