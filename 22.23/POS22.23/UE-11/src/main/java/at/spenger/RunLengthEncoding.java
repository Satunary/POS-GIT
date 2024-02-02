package at.spenger;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RunLengthEncoding {
    public String comp(String inputDataPath,String outputDataPath){
        FileReader f = null;
        try {
            f = new FileReader(inputDataPath);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        int tempcount = 1;
        String erg="";
        String s = "";
        String sHolder = "";
        boolean needed = false; //there is no reason for this name it's just a variable to keep track of what has been used


        try {
            while ((s=b.readLine()) !=null){
                s=s.replaceAll("[^a-zA-Z]","");
               for(int i=1;i<=s.length();i++){
                   if(sHolder.equals(s.substring(i-1,i))){
                       tempcount++;
                   }else {
                       if (tempcount>2){
                           erg=erg.concat(sHolder+tempcount);
                           tempcount=1;
                            needed=true;
                       }
                       if(tempcount==2) {
                           erg=erg.concat(sHolder+sHolder);
                           tempcount=1;
                           needed=true;
                       }
                       if(!needed) {
                           erg=erg.concat(sHolder);
                           needed=true;
                       }
                       if(needed){
                           needed = false;
                           tempcount=1;
                           sHolder=s.substring(i-1,i);
                       }

                   }
               }
                if (tempcount>2){
                    erg=erg.concat(sHolder+tempcount);
                }
                if(tempcount==2) {
                    erg=erg.concat(sHolder+sHolder);
                }
                if(tempcount==1) {
                    erg=erg.concat(sHolder);
                }
            }
        }
        catch (IOException e){
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

    public String deComp(String inputDataPath,String outputDataPath){
        FileReader f = null;
        try {
            f = new FileReader(inputDataPath);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
        BufferedReader b = new BufferedReader(f);
        String erg="";
        String s = "";
        String sHolder = "";
        String sCountHolder = "";
        int count=0;


        try {
            while ((s=b.readLine()) !=null){

                for(int i=1;i<=s.length();i++){
                    if(s.substring(i-1,i).matches("\\d+")){
                        for (;i<=s.length()&&s.substring(i-1,i).matches("\\d+");i++){
                            sCountHolder=sCountHolder.concat(s.substring(i-1,i));
                        }
                        count=Integer.parseInt(sCountHolder)-1;
                        sCountHolder="";
                        while (count>0){
                            erg=erg.concat(sHolder);
                            count--;
                        }
                    }
                    sHolder=s.substring(i-1,i);
                    erg=erg.concat(sHolder);
                }
            }
        }
        catch (IOException e){
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
}
