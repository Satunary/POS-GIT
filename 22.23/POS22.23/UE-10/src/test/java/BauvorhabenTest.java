import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BauvorhabenTest {

    @Test
    void kosten() {
        Bauvorhaben bv = new Bauvorhaben();
        Baulos bl = new Baulos("01","RSI", LocalDate.of(1990,1,1),LocalDate.of(2223,1,1));
        Arbeiter a = new Arbeiter("Paul",LocalDate.of(1970,1,1),30,20.5);
        bl.zuteilen(a);
        bv.einfuegen(bl);

        double act = bv.kosten();

        assertEquals(30*20.5,act);
    }

    @Test
    void anzahlOffen() {
        Bauvorhaben bv = new Bauvorhaben();
        Baulos bl = new Baulos("01","RSI", LocalDate.of(1990,1,1),LocalDate.of(2223,1,1));
        Arbeiter a = new Arbeiter("Paul",LocalDate.of(1970,1,1),30,20.5);
        bl.zuteilen(a);
        bv.einfuegen(bl);

        int act=bv.anzahlOffen();

        assertEquals(1,act);
    }

    @Test
    void print() {
        Bauvorhaben bv = new Bauvorhaben();
        Baulos bl = new Baulos("01","RSI", LocalDate.of(1990,1,1),LocalDate.of(2223,1,1));
        Arbeiter a = new Arbeiter("Paul",LocalDate.of(1970,1,1),30,20.5);
        bl.zuteilen(a);
        bv.einfuegen(bl);

        bv.print();
    }
}