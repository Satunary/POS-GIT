package at.spenger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class runLengthEncodingTest {

    @Test
    void comp() {
        RunLengthEncoding rn = new RunLengthEncoding();
        String act =rn.comp(".\\src\\main\\java\\at\\spenger\\InOutPuts\\compIn",".\\src\\main\\java\\at\\spenger\\InOutPuts\\compOut");

        assertEquals("A10E5RRCA5",act);
    }

    @Test
    void deComp() {
        RunLengthEncoding rn = new RunLengthEncoding();
        String act =rn.deComp(".\\src\\main\\java\\at\\spenger\\InOutPuts\\decompIn",".\\src\\main\\java\\at\\spenger\\InOutPuts\\decompOut");

        assertEquals("AAAAABBBBBBBBBBBCC",act);
    }
}