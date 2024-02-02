import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AOC {
    public static void main(String[] args) throws IOException {
        FileReader f = null;
        try {
            f = new FileReader("C:\\Users\\Maximilian\\OneDrive - HTL Spengergasse\\Schule\\Pos\\22.23\\input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        int erg = 0;
        int tempErg = 0;
        ArrayList<Integer> ergList = new ArrayList<>();
        String s = "";

        try {
            while ((s=b.readLine()) !=null){
                if (s.isEmpty()){
                    for (int y=0;y<ergList.size();y++){
                        tempErg+=ergList.get(y);
                    }
                    if (erg<tempErg) {
                        erg = tempErg;
                    }
                    tempErg=0;
                    ergList.removeAll(ergList);
                }else {
                    ergList.add(Integer.parseInt(s));
                }
            }
        }
        catch (IOException e){
        }
        System.out.print(erg);
    }
}
