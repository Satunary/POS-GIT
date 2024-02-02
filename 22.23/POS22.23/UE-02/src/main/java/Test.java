public class Test {
    public static void main(String[] args) {

        //erstelleung der Objekte
        Mitarbeiter m0 = new Mitarbeiter("DC", "Walter", "Tcher", 1200.0f);
        Mitarbeiter m1 = new Mitarbeiter("DC", "Daniel", "Nebel", 500.0f);
        Mitarbeiter m2 = new Mitarbeiter("Mag", "Termer", "Kolman", 300.0f);
        Mitarbeiter m3 = new Mitarbeiter("Mag", "Simon", "Lojnik", 700.0f);

        MitarbeiterVerwaltung mk = new MitarbeiterVerwaltung();
        //Hinzufügen der Objekte
        mk.addMitarbeiter(m0);
        mk.addMitarbeiter(m1);
        mk.addMitarbeiter(m2);
        mk.addMitarbeiter(m3);
        //entfernen test
        boolean t0=mk.delMitarbeiter(m0);
        boolean t1=mk.delMitarbeiter(m0);
        if(!(t1)&& t0){
            System.out.println("Del funktioniert");
        }
        mk.addMitarbeiter(m0);
        //gesamt Umsatzt test

        if(mk.gesamtUmsatz()==2700){
            System.out.println("Gesamt Umsatz funktioniert");
        }else{
            System.out.println(mk.gesamtUmsatz());
            throw new IllegalArgumentException("Gesamtumsatz Funktioniert nicht");
        }
        // toString test
        if(mk.toString().equals("""
                Titel: DC |Vorname: Daniel |Nachname: Nebel |Umsatz: 500.0
                Titel: Mag |Vorname: Termer |Nachname: Kolman |Umsatz: 300.0
                Titel: Mag |Vorname: Simon |Nachname: Lojnik |Umsatz: 700.0
                Titel: DC |Vorname: Walter |Nachname: Tcher |Umsatz: 1200.0
                """)){
            System.out.println("To String funktioniert");
        }else {
            System.out.println("To String funktioniert nicht");
        }
        // setUmsaetze test
        mk.setUmsaetze(500.0f);
        if(mk.gesamtUmsatz()==3700){
            System.out.println("Set Umsaetze funktioniert");
        }else {
            throw new IllegalArgumentException("setUmsaetze Funktioniert nicht");
        }

    }
}
