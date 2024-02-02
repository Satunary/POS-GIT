public class Mitarbeiter {
    private String titel;
    private String vorname;
    private String nachname;
    private float umsatz;

    public Mitarbeiter(String titel, String vorname, String nachname, float umsatz) {
        setTitel(titel);
        setVorname(vorname);
        setNachname(nachname);
        setUmsatz(umsatz);
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setVorname(String vorname) {
        if (vorname.length() < 2 || vorname.equals("null")) {
            System.out.println("Vorname Falsch");
            this.vorname = "Max";
        }else {
            this.vorname = vorname;
        }
    }

    public void setNachname(String nachname) {
        if  (nachname.length() < 2 || nachname.equals("null")) {
            System.out.println("Nachname Falsch");
            this.nachname = "Muster";
        }
        else {
            this.nachname = nachname;
        }
    }

    public void setUmsatz(float umsatz) {
        if (umsatz <= 0) {
            System.out.println("Umstz muss über 0 sein");
            this.umsatz=1500.0f;
        }else {
            this.umsatz = umsatz;
        }
    }

    public float getUmsatz() {
        return umsatz;
    }

    public String toString() {
        return "Titel: " + titel + " |Vorname: " + vorname + " |Nachname: " + nachname + " |Umsatz: " + umsatz;
    }

    public boolean equals(Mitarbeiter m0) {
        Mitarbeiter m = (Mitarbeiter) m0;
        if ((m.titel.equals(titel) && m.vorname.equals(vorname) && m.nachname.equals(nachname))) {
            return true;
        } else {
            return false;
        }
    }
}
