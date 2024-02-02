public class Haustier {
    private float gewicht;
    private String name;

    public Haustier(float gewicht, String name){
        setName(name);
        setGewicht(gewicht);
    }

    public Haustier(){
        setName("Anton");
        setGewicht(15);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGewicht(float gewicht) {
        if(gewicht>0){
            this.gewicht = gewicht;
        }
    }
    public String toString(){
        return "Name: "+name+", Gewicht: "+gewicht;
    }
    public String geraeuschMachen(){
        return "???";
    }
}
