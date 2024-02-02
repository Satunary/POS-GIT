import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) {
        Stock s0=new Stock("Paul",LocalDate.of(2010,10,10),3,false);
        Stock s1=new Stock("Paul",LocalDate.of(2010,10,10),3,true);
        Stock s2=new Stock("Samuel",LocalDate.of(2011,3,10),4,false);
        Weinberg w=new Weinberg("Heinrich", 1);
        //Einfügen von Stöcken
        w.setztenEnde(s0);
        w.setzenAnfang(s1);
        w.setztenEnde(s2);
        try{
                w.setztenEnde(s1);
        }catch (Exception e){
            System.out.println("setzenEnde Error funktioniert");
        }
        //printen
        w.print();
        System.out.println("-----------------------");
        w.printGruppiert();
        w.entfernen(s0);
        System.out.println("-----------------------");
        w.print();
        w.setztenEnde(s0);
        w.entfernenAlle();
        System.out.println("-----------------------");
        w.print();

    }
}