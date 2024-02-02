public class LKW
{
    private int raeder;
    private boolean mitAnhaenger;
    private double nutzlast;
    
    public LKW()
    {
        this.mitAnhaenger=true;
        setRaeder(8);
        setNutzlast(1200);
    }
    public LKW(int raeder, boolean mitAnhaenger, double nutzlast)
    {
        this.mitAnhaenger=mitAnhaenger;
        setRaeder(raeder);
        setNutzlast(nutzlast);
    }
    
    public void setRaeder(int raeder)
    {
        if(raeder % 2 == 0 && (mitAnhaenger && raeder >= 6 && raeder <=10 || mitAnhaenger==false && raeder >=4 && raeder <=10))
        {
            this.raeder=raeder;
        }
        else
        {
            if(!(raeder%2==0))
            {
                System.out.println("Räder ist nicht gerade");
            }
            if(mitAnhaenger && raeder <6)
            {
                System.out.println("Man braucht mehr als 6 räder mit Anhänger");
            }
            if(mitAnhaenger==false && raeder <4)
            {
                System.out.println("Ohne Anhänger braucht man mindestens 4 Räder");
            }
            if(raeder>10)
            {
                System.out.println("Zu viele Räder");
            }
            this.raeder=6;
        }
    }
    public void setMitAnhaenger(boolean mitAnhaenger)
    {
        if ((mitAnhaenger==true && raeder>=6) || (mitAnhaenger == false && raeder >=4))
        {
            this.mitAnhaenger=mitAnhaenger;
        }
        else
        {
            System.out.println("Nicht genug Räder");
            this.mitAnhaenger = false;
        }
    }
    public void setNutzlast(double nutzlast)
    {
        if ((mitAnhaenger&&(nutzlast<= (raeder*200 + 400))|| mitAnhaenger==false&&(nutzlast<=(raeder*200))))
        {
            this.nutzlast=nutzlast;
        }
        else
        {
            System.out.println("Zu wenig Räder");    
        }
    }
    public void printLKW()
    {
        System.out.println("Räder: "+raeder);
        System.out.println("Mit Anhänger: "+mitAnhaenger);
        System.out.println("Nutzlast: "+(nutzlast/1000)+" t");
    }
}
