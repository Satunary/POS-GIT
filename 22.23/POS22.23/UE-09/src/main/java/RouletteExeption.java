public class RouletteExeption extends RuntimeException{
    public RouletteExeption (){
        super("ERROR");
    }
    public RouletteExeption(String fehlermeldung){
        super(fehlermeldung);
    }
}
