public class Schueler {
    private String nachname;
    private String vorname;
    private int alter;

    public Schueler(){
        setAlter(15);
        setNachname("Hödel");
        setVorname("Monika");
    }
    public Schueler(int alter, String vornahme, String nachname){
        setVorname(vornahme);
        setNachname(nachname);
        setAlter(alter);
    }

    public int getAlter() {
        return alter;
    }

    public String getNachname() {
        return nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setAlter(int alter) {
        if(alter>5){
            this.alter = alter;
        }else{
            this.alter=15;
        }
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String toString(){
        return "Vorname:"+vorname+" Nachname:"+nachname+" Alter:"+alter;
    }
}
