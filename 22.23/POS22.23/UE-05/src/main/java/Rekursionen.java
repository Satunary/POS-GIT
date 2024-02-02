import java.math.MathContext;
import java.util.Random;

public class Rekursionen {

    public int faktoriel(int n) {
        if (n - 1 > 0) {
            return faktoriel(n - 1) * n;
        } else {
            return 1;
        }
    }

    public int ggT(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return ggT(b, a % b);

        }
    }

    public int sum(int z) {
        Random r = new Random();
        int erg = 0;
        if (z - 1 >= 0) {
            return erg + 5 + r.nextInt(6) + sum(z - 1);
        } else {
            return 1;
        }
    }

    public void teilbar(int von, int bis, int zahl) {
        if (bis - von > 0) {
            if (von % zahl == 0) {
                System.out.print(von + ",");
            }
            teilbar(von + 1, bis, zahl);
        }
    }

    public int sumIterativ() {
        Random r = new Random();
        int[] x = new int[10];
        for (int i = 0; i < 11; i++) {
            x[i] = r.nextInt(10);
        }
        int erg = 0;
        for (int i = 0; i < 11; i++) {
            erg += x[i];
        }
        return erg;
    }

    public void sumReku() {
        Random r = new Random();
        int[] x = new int[10];
        for (int y = 0; y < 10; y++) {
            x[y] = r.nextInt(10);
        }
        int i = -1;
        int erg = 0;
        summ(x, i, erg);
    }

    private int summ(int[] x, int i, int erg) {
        //rechenmethode zu sumReku
        if (i < 9) {
            i++;
            erg += x[i] + summ(x, i, erg);
            if (i != 0) {
                System.out.print(x[i] + "+");
            }
            if (i == 0) {
                System.out.print(x[i] + "=" + erg);
            }
            return erg;
        } else {
            return 1;
        }
    }

    private int summ2(int[] x, int i, int erg) {
        //rechenmethode zu sumRekuRuckwaerts
        if (i > 0) {
            i--;
            erg += x[i] + summ2(x, i, erg);
            if (i != 9) {
                System.out.print(x[i] + "+");
            }
            if (i == 9) {
                System.out.print(x[i] + "=" + erg);
            }
            return erg;
        } else {
            return 1;
        }
    }

    public void sumRekuRuckwaerts() {
        Random r = new Random();
        int[] x = new int[10];
        for (int y = 0; y < 10; y++) {
            x[y] = r.nextInt(10);
        }
        int i = 10;
        int erg = 0;
        summ2(x, i, erg);
    }

    private void rechnerFolgel(int b, int x, int y) {
        if (!(y < b)) {
            System.out.print(x + "/" + y + " ");
            rechnerFolgel(b, x * -3, y - 2);
        }
    }

    public void folgel(int a, int b) {
        //laut angabe muss a größer sein als b und beide Positiv
        int x = -1;
        rechnerFolgel(b, x, a);
    }


    public void ziffernsumme(int zahl) {
        char[] c = Integer.toString(zahl).toCharArray();
        System.out.println("ziffernsumme(" + zahl + ")-> return: " + Math.abs(ziffernsumme(c, c.length - 1)));
    }


    private int ziffernsumme(char[] c, int durchlauf) {
        //rechenmethode zu ziffernsumme
        if (durchlauf > 1) {
            return Integer.parseInt(String.valueOf(c[durchlauf])) + ziffernsumme(c, durchlauf - 1);
        }
        if (c[0] == '-') {
            return Integer.parseInt(String.valueOf(c[1])) * -1;
        }
        return Integer.parseInt(String.valueOf(c[1])) + Integer.parseInt(String.valueOf(c[0]));
    }

    public void baum(int hoehe) {
        int baseSpa = 0;
        int spa = baseSpa;
        int symb = hoehe * 2 - 1;
        int baseSymb = symb;
        zeichnerBaum(baseSpa, hoehe, spa, symb, baseSymb);
    }

    //zeichenmethoden für Baum
    private void zeichnerBaum(int baseSpa, int hoehe, int spa, int symb, int baseSymb) {
        if (hoehe > 0) {
            zeichnerBaum(baseSpa + 1, hoehe - 1, baseSpa + 1, baseSymb - 2, baseSymb - 2);
            zeicnerSpa(spa);
            zeicnerSymb(symb);
            System.out.println();
        }

    }

    private void zeicnerSpa(int spa) {
        if (spa > 0) {
            zeicnerSpa(spa - 1);
            System.out.print(" ");
        }
    }

    private void zeicnerSymb(int symb) {
        if (symb > 0) {
            zeicnerSymb(symb - 1);
            System.out.print("*");
        }
    }

    public void RFalling(int hoehe, int zeit, int count) {
        //rechen bzw zeichenethode zu falling
        if (count <= zeit && 0.5 * 9.80665 * count * count < hoehe) {

            if (count == 0) {
                System.out.println("Sekunden -> Entfernung  (Abwurf-Höhe:  " + hoehe + ")");
                System.out.println("----------------------------------------------");
            }
            System.out.println("   " + count + "    ->    " + 0.5 * 9.80665 * count * count);

            RFalling(hoehe, zeit, count + 1);
        } else if (count == zeit && 0.5 * 9.80665 * count * count >= hoehe) {
            System.out.println("   " + count + "    ->    Handy Kaputt");
        } else if (count > zeit) {
            System.out.println("Versuchsabbruch zeitüberschreiung");
        }
    }

    public void falling(int hoehe, int zeit) {
        int count = 0;
        RFalling(hoehe, zeit, count);
    }

}
