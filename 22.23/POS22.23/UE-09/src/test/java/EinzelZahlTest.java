import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EinzelZahlTest {

    @Test
    void berechneGewinn() {
        EinzelZahl e=new EinzelZahl("Tim",50,20);

        int act=e.berechneGewinn(20);

        assertEquals(1750,act);
    }

    @Test
    void testToString() {
        EinzelZahl e=new EinzelZahl("Tim",50,20);

        String act = e.toString();

        assertEquals("Name: Tim, Betrag: 50, gesetzte Zahl: 20",act);
    }
    @Test
    void testExeption(){
        assertThrows(RuntimeException.class,() -> {new EinzelZahl("Tim",-50,20);});
    }
}