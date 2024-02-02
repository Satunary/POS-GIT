import static org.junit.jupiter.api.Assertions.*;

class SpielTest {

    @org.junit.jupiter.api.Test
    void entfernen() {
        Spiel s=new Spiel();
        s.setzten(new EinzelZahl("Paul",50,30));
        s.kugelWerfen();

        int act = s.entfernen("Paul");

        assertEquals(1,act);
    }

    @org.junit.jupiter.api.Test
    void sortierenUgewinnListeUberechneErtrag() {
        Spiel s=new Spiel();
        s.setzten(new EinzelZahl("Paul",50,30));
        s.setzten(new Dutzend("Tim",30,3));
        s.setzten(new GeradeUngerade("Simon",10,false));
        s.setzten(new Kolonne("Laurenz",100,1));

        s.kugelWerfen();
        System.out.println("Gewürfelter wert: "+s.getGewinnZahl());
        System.out.println("Gewinn für das Casino: "+s.berechneErtrag()+"€");
        System.out.println();
        System.out.println("Vorher");
        System.out.println(s.gewinnListe());
        System.out.println("------------------------------------");
        System.out.println("Nachher");
        s.sortieren();
        System.out.println(s.gewinnListe());
    }

    @org.junit.jupiter.api.Test
    void sortierenBetrag() {
        Spiel s=new Spiel();
        s.setzten(new EinzelZahl("Paul",50,30));
        s.setzten(new Dutzend("Tim",30,3));
        s.setzten(new GeradeUngerade("Simon",10,false));
        s.setzten(new Kolonne("Laurenz",100,1));

        s.kugelWerfen();
        System.out.println("Gewürfelter wert: "+s.getGewinnZahl());
        System.out.println("Gewinn für das Casino: "+s.berechneErtrag()+"€");
        System.out.println();
        System.out.println("Vorher");
        System.out.println(s.gewinnListe());
        System.out.println("------------------------------------");
        System.out.println("Nachher");
        s.sortierenBetrag();
        System.out.println(s.gewinnListe());
    }

    @org.junit.jupiter.api.Test
    void sortierenName() {
        Spiel s=new Spiel();
        s.setzten(new EinzelZahl("Paul",50,30));
        s.setzten(new Dutzend("Tim",30,3));
        s.setzten(new GeradeUngerade("Simon",10,false));
        s.setzten(new Kolonne("Laurenz",100,1));

        s.kugelWerfen();
        System.out.println("Gewürfelter wert: "+s.getGewinnZahl());
        System.out.println("Gewinn für das Casino: "+s.berechneErtrag()+"€");
        System.out.println();
        System.out.println("Vorher");
        System.out.println(s.gewinnListe());
        System.out.println("------------------------------------");
        System.out.println("Nachher");
        s.sortierenName();
        System.out.println(s.gewinnListe());
    }
}