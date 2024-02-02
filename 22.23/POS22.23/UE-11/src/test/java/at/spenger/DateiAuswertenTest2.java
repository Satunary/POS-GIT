package at.spenger;

import static org.junit.jupiter.api.Assertions.*;

class DateiAuswertenTest2 {

    @org.junit.jupiter.api.Test
    void statistikZeichen() {
        DateiAuswerten da = new DateiAuswerten();
        String act= da.statistikZeichen(".\\src\\main\\java\\at\\spenger\\InOutPuts\\zeichenIn",".\\src\\main\\java\\at\\spenger\\InOutPuts\\zeichenOut");

        assertEquals("Buchstabenliste\nA: 1\nH: 1\nL: 2\nO: 1",act);
    }

    @org.junit.jupiter.api.Test
    void statistikWoerter() {
        DateiAuswerten da = new DateiAuswerten();
        String act= da.statistikWoerter(".\\src\\main\\java\\at\\spenger\\InOutPuts\\woerterIn",".\\src\\main\\java\\at\\spenger\\InOutPuts\\woerterOut");
    }
}