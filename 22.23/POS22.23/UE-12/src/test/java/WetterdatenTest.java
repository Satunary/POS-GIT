import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WetterdatenTest {

    @org.junit.jupiter.api.Test
    void add2Ungleich() {
        Messwert m1 = new Messwert(LocalDate.now(),15,1);
        Messwert m2 = new Messwert(LocalDate.of(1995,1,1),20,2);
        Wetterdaten wd = new Wetterdaten();

        wd.add(m1);
        wd.add(m2);

        assertEquals(2,wd.getDaten().size());
    }

    @org.junit.jupiter.api.Test
    void add2Gleich() {
        Messwert m1 = new Messwert(LocalDate.of(1995,1,1),15,1);
        Messwert m2 = new Messwert(LocalDate.of(1995,1,1),20,2);
        Wetterdaten wd = new Wetterdaten();
        try {
            wd.add(m1);
            wd.add(m2);
        }
       catch (IllegalArgumentException e){
            assertTrue(true);
            return;
       }

        assertTrue(false);
    }

    @org.junit.jupiter.api.Test
    void readFile() {
        Wetterdaten wd = new Wetterdaten();
        File f = new File(".\\src\\main\\java\\FileIn");
        wd.readFile(f);

        assertEquals(2,wd.getDaten().size());
    }

    @org.junit.jupiter.api.Test
    void readFileIdentical() {
        Wetterdaten wd = new Wetterdaten();
        File f = new File(".\\src\\main\\java\\FileIn");
        wd.readFile(f);
        ArrayList<Messwert> ma = new ArrayList<>();
        ma.add(Messwert.getMesswert("15.12.1995:10:1"));
        ma.add(Messwert.getMesswert("20.01.2000:20:3"));

        assertEquals(ma,wd.getDaten());
    }
}