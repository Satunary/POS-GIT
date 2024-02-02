import static org.junit.jupiter.api.Assertions.*;

class RekursionenTest {


    public static void main(String[] args) {
        Rekursionen re =new Rekursionen();
        System.out.println("expected output: 6");
        System.out.println(re.faktoriel(3));
        System.out.println("#####################################");

        System.out.println("expected output: 3");
        System.out.println(re.ggT(15,18));
        System.out.println("#####################################");

        System.out.println("expected output: Random nicht vors");
        System.out.println(re.sum(2));
        System.out.println("#####################################");

        System.out.println("expected output: 15,80,21,24,27,30,33,36,39");
        re.teilbar(15,40,3);
        System.out.println();
        System.out.println("#####################################");

        System.out.println("expected output: Random nicht vorherseebar");
        re.sumReku();
        System.out.println();
        System.out.println("#####################################");


        re.folgel(50,40);
        System.out.println();
        System.out.println("#####################################");


        re.ziffernsumme(234);
        System.out.println("#####################################");


        re.baum(3);
        System.out.println("#####################################");


        re.falling(150,5);

    }
}