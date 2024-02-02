package at.spenger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class DateiAuswerten {

   public String statistikZeichen(String inputDataPath,String outputDataPath){
        FileReader f = null;
        try {
            f = new FileReader(inputDataPath);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        HashMap<String,Integer> ergList = new HashMap<>();
        String s = "";
        String erg = "Buchstabenliste";

        try {
            while ((s=b.readLine()) !=null){
                s=s.toUpperCase();
                for(int i=1;i<=s.length();i++){
                    if(ergList.containsKey(s.substring(i-1,i))){
                        ergList.put(s.substring(i-1,i), ergList.get(s.substring(i-1,i))+1);
                    }
                    else {
                        ergList.put(s.substring(i - 1, i), 1);
                    }
                }
            }
        }
        catch (IOException e){
        }

       for (String s1 : ergList.keySet()){
           erg=erg.concat("\n"+s1+": "+ergList.get(s1));
       }

        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new FileWriter(outputDataPath));
            pWriter.println(erg);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        System.out.print(erg);
        return erg;
    }

    public String statistikWoerter(String inputDataPath,String outputDataPath){
        FileReader f = null;
        try {
            f = new FileReader(inputDataPath);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        HashMap<String,Integer> ergList = new HashMap<>();
        List<String> sL;
        String s = "";
        String erg = "Buchstabenliste";
        String sTemp="";

        try {
            while ((s=b.readLine()) !=null){
                s=s.replaceAll("[^a-zA-Z\s]","");
                sL= Arrays.asList(s.split(" "));
                for(int i=0;i<sL.size();i++){
                    sTemp=sL.get(i);
                    if ((sTemp.length()>1)&&sTemp.substring(0,1).matches("\\s")){
                        sTemp=sTemp.substring(1);
                    }
                        if(ergList.containsKey(sTemp)){
                            ergList.put(sTemp,ergList.get(sTemp)+1);
                        }
                        else {
                            ergList.put(sTemp, 1);
                        }

                }
            }
        }
        catch (IOException e){
        }

        for (String s1 : ergList.keySet()){
            erg=erg.concat("\n"+s1+": "+ergList.get(s1));
        }

        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new FileWriter(outputDataPath));
            pWriter.println(erg);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }
        }
        System.out.print(erg);
        return erg;
    }

    public static void main(String[] args) {
        String t = "Wolrd World!";
        t=t.replaceAll("[^a-zA-Z0-9\s]","");
        List tL = Arrays.asList(t.split(" "));
        System.out.println(tL);
    }
}
