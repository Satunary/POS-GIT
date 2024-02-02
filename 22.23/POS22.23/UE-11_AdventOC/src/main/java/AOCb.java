import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AOCb {
    public static void main(String[] args) throws IOException {
        FileReader f = null;
        try {
            f = new FileReader("C:\\Users\\Maximilian\\OneDrive - HTL Spengergasse\\Schule\\Pos\\22.23\\input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        ArrayList<Integer> erg = new ArrayList<>();
        int tempErg = 0;
        ArrayList<Integer> ergList = new ArrayList<>();
        String s = "";

        try {
            while ((s=b.readLine()) !=null){
                if (s.isEmpty()){
                    for (int y=0;y<ergList.size();y++){
                        tempErg+=ergList.get(y);
                    }
                    erg.add(tempErg);
                    tempErg=0;
                    ergList.removeAll(ergList);
                }else {
                    ergList.add(Integer.parseInt(s));
                }
            }
        }
        catch (IOException e){

        }

        CompareBetrag cmb = new CompareBetrag();
        erg.sort(cmb);
        System.out.print((erg.get(0)+erg.get(1)+erg.get(2)));
    }
}
