package at.spenger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LiederListeTest {

    @org.junit.jupiter.api.Test
    void addUAnzahlLieder() {
        LiederListe ll=new LiederListe();

        ll.add(new Lied("World Cup","Schuni",500, LocalDate.of(2022,1,2)));
        int actual = ll.anzahlLieder();

        assertEquals(1,actual);
    }

    @org.junit.jupiter.api.Test
    void vorhanden() {
        LiederListe ll=new LiederListe();

        ll.add(new Lied("World Cup","Schuni",500, LocalDate.of(2022,1,2)));
        boolean act=ll.vorhanden(new Lied("World Cup","Schuni",500, LocalDate.of(2022,1,2)));

        assertTrue(act);
    }

    @org.junit.jupiter.api.Test
    void istLiedvorhanden() {
        LiederListe ll=new LiederListe();
        Lied l=new Lied("World Cup","Schuni",500, LocalDate.of(2022,1,2));

        ll.add(l);
        boolean act=ll.vorhanden(l);

        assertEquals(true,act);
    }
}