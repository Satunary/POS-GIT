
public class Sportauto
{
    private int ps;
    private String marke;
    private Person fahrer;
    
    public Sportauto()
    {
        ps=500;
        marke="VW";
        fahrer = new Person(20);
        if (fahrer == null)
        {
            System.out.println("Fahrer ERROR");
        }
    }
    
}
