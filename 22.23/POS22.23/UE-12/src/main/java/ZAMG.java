import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

public class ZAMG {
    private HashMap<String,Wetterdaten> ortsWetter;
    
    public ZAMG(){
        ortsWetter=new HashMap<>();
    }
    
    public Wetterdaten addMesswert(String ort, Wetterdaten wd){
        if (wd==null || ort == ""){
            throw new IllegalArgumentException("ort oder Messwert ungültig");
        }
        if (ortsWetter.containsKey(ort)){
           Wetterdaten ret = ortsWetter.get(ort);
            ortsWetter.put(ort,wd);
            return ret;
        }
        ortsWetter.put(ort,wd);
        return null;
    }
    
    public Wetterdaten addMesswert(String ort, File f){
        Wetterdaten wd = new Wetterdaten();
        wd.readFile(f);
        return addMesswert(ort,wd);
    }

    public void loeschen(int jahr){
        for (String s : ortsWetter.keySet()){
            ortsWetter.get(s).del(jahr);
        }
    }

    public void save(File f){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
            pw.println("");
            for (String s : ortsWetter.keySet()){
                ortsWetter.get(s).saveFile(f);
            }
        }
        catch (IOException e){

        }
    }
}
