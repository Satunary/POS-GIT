import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrchesterTest {

    @org.junit.jupiter.api.Test
    void einfügen() {
        Orchester o = new Orchester();
        Hafrenspieler h= new Hafrenspieler();
        Waldhorn w = new Waldhorn();

        o.einfügen(h);
        o.einfügen(w);

        //System.out.println(o.toString());
        String act=o.toString();

        assertEquals("Name: Filler\nGeburts Datum: 01 01 2000\nStunden: 35\nStundenlohn: 15.0€\nGewicht der Harfe: 10.0Kg\n----------------------\nName: Filler\nGeburts Datum: 01 01 2000\nStunden: 35\nStundenlohn: 15.0€\nrichtig gespielte Noten: 0\nfalsch gespielte Noten: 0\n----------------------",act);
    }


    @org.junit.jupiter.api.Test
    void entfernen() {
        Orchester o = new Orchester();
        Hafrenspieler h= new Hafrenspieler();
        Waldhorn w = new Waldhorn();

        o.einfügen(h);
        o.einfügen(w);
        o.entfernen(w);
        String act = o.toString();

        assertEquals("Name: Filler\nGeburts Datum: 01 01 2000\nStunden: 35\nStundenlohn: 15.0€\nGewicht der Harfe: 10.0Kg\n----------------------",act);
    }

    @org.junit.jupiter.api.Test
    void aelteste() {
        Orchester o = new Orchester();
        Hafrenspieler h= new Hafrenspieler(LocalDate.of(1998,12,12),"Tom",40,20,15);
        Waldhorn w = new Waldhorn();

        o.einfügen(h);
        o.einfügen(w);

        Kuenstler[] exp = new Kuenstler[1];
        exp[0]=h;

        Kuenstler[] act=new Kuenstler[1];
        act=o.aelteste(1);

        assertArrayEquals(exp,act);
    }



    @org.junit.jupiter.api.Test
    void geld() {
        Orchester o = new Orchester();
        Hafrenspieler h= new Hafrenspieler();
        Waldhorn w = new Waldhorn();

        o.einfügen(h);
        o.einfügen(w);
        double act=o.geld();

        assertEquals(1550,act);
    }
}