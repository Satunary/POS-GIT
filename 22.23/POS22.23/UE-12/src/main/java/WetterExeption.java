public class WetterExeption extends RuntimeException{
    private enum Typ{
        DATUM,
        MESSDATEN
    }
    private Typ typ;
    public WetterExeption (String t){
        super("Messdaten");
        typ = Typ.valueOf(t);
    }

    public Typ getTyp() {
        return typ;
    }
}
