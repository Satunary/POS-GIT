import static org.junit.jupiter.api.Assertions.*;

class TierhandlungTest {

    @org.junit.jupiter.api.Test
    void einfuegen() {
        Tierhandlung t=new Tierhandlung();
        Hund h=new Hund(15.0f,"anton","Nix");
        t.einfuegen(h);

        String act=t.toString();

        assertEquals("Name: anton, Gewicht: 15.0, Fähigkeiten: Nix\n",act);
    }

    @org.junit.jupiter.api.Test
    void entfernen() {
        Tierhandlung t=new Tierhandlung();
        Hund h0=new Hund(15.0f,"anton","Nix");
        Katze k1=new Katze(30.0f,"Sandy","Kill");
        t.einfuegen(h0);
        t.einfuegen(k1);

        t.entfernen(k1);
        String s=t.toString();

        assertEquals("Name: anton, Gewicht: 15.0, Fähigkeiten: Nix\n",s);
    }

    @org.junit.jupiter.api.Test
    void anzahl() {
        Tierhandlung t=new Tierhandlung();
        Hund h0=new Hund(15.0f,"anton","Nix");
        Katze k1=new Katze(30.0f,"Sandy","Kill");
        t.einfuegen(h0);
        t.einfuegen(k1);

        int i=t.anzahl();

        assertEquals(2,i);
    }

    @org.junit.jupiter.api.Test
    void gerauscheMachen() {
        Tierhandlung t=new Tierhandlung();
        Hund h0=new Hund(15.0f,"anton","Nix");
        Katze k1=new Katze(30.0f,"Sandy","Kill");
        t.einfuegen(h0);
        t.einfuegen(k1);

        System.out.println("Erwartet: \nWau Wau\n Miau");
        System.out.println("Output:");
        t.gerauscheMachen();
    }

    @org.junit.jupiter.api.Test
    void print() {
        Tierhandlung t=new Tierhandlung();
        Hund h=new Hund(15.0f,"anton","Nix");
        t.einfuegen(h);

        System.out.println("Expected: \nName: anton, Gewicht: 15.0, Fähigkeiten: Nix");
        System.out.println("Output:");
        t.print();
    }

    @org.junit.jupiter.api.Test
    void anzahlAn(){
        Tierhandlung t=new Tierhandlung();
        Hund h0=new Hund(15.0f,"anton","Nix");
        Katze k1=new Katze(10.0f,"Sandy","Black");
        Katze k2=new Katze(15.0f,"Samir","White");
        t.einfuegen(h0);
        t.einfuegen(k1);
        t.einfuegen(k2);

        int ac=t.anzahlAn(k2);

        assertEquals(2,ac);
    }
}