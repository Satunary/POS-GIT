package at.spenger.ue16;

import at.spenger.ue16.compares.CompFlaeche;
import at.spenger.ue16.compares.CompRed;
import at.spenger.ue16.fig.Fig2D;
import at.spenger.ue16.fig.Kreis;
import at.spenger.ue16.fig.Rechteck;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Zeichnung {
    private ArrayList<Fig2D> col;
    private int lastPos;

    public Zeichnung(){
        col=new ArrayList<>();
        lastPos=0;
    }

    public void addFig(Fig2D fi){
        if (col.contains(fi)||fi==null){
            throw new IllegalArgumentException("Allready exists or is null");
        }
        col.add(fi);
    }

    public int readFig(File f) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
        }
        String s = "";
        int x=0;
        try {
            while ((s = bf.readLine())!=null){
                col.add(implement(s));
                x++;
            }
        }catch (IOException e) {
            System.out.println("Not a valid input");
        }
        return x;
    }

    public void save(File f){
        PrintWriter pr = null;
        try {
            pr=new PrintWriter(f);
            for (int i=0; i<col.size();i++){
                pr.println(col.get(i).toString());
            }
        }catch (IOException e){

        }
        finally {
            if (pr!=null){
                pr.flush();
                pr.close();
            }
        }
    }

    public void deleteFig(Fig2D fi){
        if (col.contains(fi)){
            col.remove(fi);
        }else {
            throw new IllegalArgumentException("Nonexistent figure");
        }
    }
    public void clearAll(){
        int i=col.size()-1;
        while(i>=0){
            col.remove(i);
            i--;
        }
        lastPos=0;
    }

    public void save(double x,double y,double with,double hight,File f){
        PrintWriter pr = null;
        try {
            pr=new PrintWriter(f);
            for (int i=0; i<col.size();i++){
                if (col.get(i).getX()<=(x+with) && col.get(i).getX()>=x && col.get(i).getY()<=(y+hight) && col.get(i).getY()>=y){
                    pr.println(col.get(i).toString());
                }
            }
        }catch (IOException e){

        }
        finally {
            if (pr!=null){
                pr.flush();
                pr.close();
            }
        }
    }

    public void sortByFlaeche(){
        Collections.sort(col,new CompFlaeche());
        for (int i=0;i<col.size();i++){
            System.out.println(col.get(i).toString());
        }
    }

    public void sortByDurchsicht(){
        Collections.sort(col,new CompRed());
        for (int i=0;i<col.size();i++){
            System.out.println(col.get(i).toString());
        }
    }

    public double gesFlaeche(){
        double erg=0;
        for (int i=0;i<col.size();i++){
            erg+=col.get(i).flaeche();
        }
        return erg;
    }

    public double gesUmfang(){
        double erg=0;
        for (int i=0;i<col.size();i++){
            erg+=col.get(i).umfang();
        }
        return erg;
    }

    public Fig2D implement(String s){
        Fig2D ret = null;
        try {
            String [] temp = s.split(" ");
            if (temp[0].equals("KR")){
                ret=(new Kreis(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]),Double.parseDouble(temp[3]), Color.valueOf(temp[4])));
            }
            if (temp[0].equals("RE")){
                ret=(new Rechteck(Double.parseDouble(temp[1]),Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Double.parseDouble(temp[4]),Color.valueOf(temp[5])));
            }
            else {
                System.out.println("Not a valid input");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Not a valid input");
        }
        return ret;
    }
    
    public void drawAllNew(ViewZeichnung view){
        while (lastPos<col.size()){
            col.get(lastPos).draw(view);
            lastPos++;
        }
    }

    public void drawLast(ViewZeichnung view){
        col.get(col.size()-1).draw(view);
        lastPos++;
    }
}
