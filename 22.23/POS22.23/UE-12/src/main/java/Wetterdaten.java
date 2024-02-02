import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Wetterdaten {
    private ArrayList<Messwert> daten = new ArrayList<>();

    public void add(Messwert m){
        if (m==null || daten.contains(m)){
            throw new IllegalArgumentException("null oder schon existent");
        }
        daten.add(m);
    }

    public void del(Messwert m){
        daten.remove(m);
    }

    public void del(int jahr){
        Iterator<Messwert> it = daten.iterator();

        while (it.hasNext()){
            Messwert m = it.next();
            if (m.getDatum().getYear()==jahr){
                it.remove();
            }
        }
    }

    public void saveFile(File file){
        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new FileWriter(file,true));
            for (int i=0;i<daten.size();i++){
                pWriter.println(daten.get(i).toString()+"\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
    }

    public void readFile(File file){
        FileReader f = null;
        try {
            f = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        String s="";
        try {
            while ((s=b.readLine()) !=null){
                daten.add(Messwert.getMesswert(s));
            }
        }
        catch (IOException e){
        }
    }

    public Messwert get(int index){
        if (index< daten.size() && index>=0){
            return daten.get(index);
        }
        return null;
    }

    public ArrayList<Messwert> getDaten(){
        return daten;
    }

}
