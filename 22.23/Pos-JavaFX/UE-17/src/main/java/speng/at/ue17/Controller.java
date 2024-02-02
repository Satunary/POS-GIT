package speng.at.ue17;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import speng.at.ue17.Model.Model;
import speng.at.ue17.Model.Rechnung;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Controller implements EventHandler<ActionEvent> {
    private View view;
    private Model model;
    private String type;
    private String rechnung;
    private int valW1;
    private int valW2;
    private int valW3;


    public Controller(String type,View view,Model model){
        this.type=type;
        this.view=view;
        this.model=model;
        rechnung="";
        ini();
    }
    @Override
    public void handle(ActionEvent actionEvent) {

        switch (type){
            case "W1":
                rechnung+=valW1;
                view.disableW(1);
                model.setCounter(model.getCounter()-1);
                System.out.println(model.getCounter());
                reset();
                break;
            case "W2":
                rechnung+=valW2;
                view.disableW(2);
                model.setCounter(model.getCounter()-1);
                System.out.println(model.getCounter());
                reset();
                break;
            case "W3":
                rechnung+=valW3;
                view.disableW(3);
                model.setCounter(model.getCounter()-1);
                System.out.println(model.getCounter());
                reset();
                break;
        }

    }

    private Rechnung rechner(){
        int erg =0;
        String[] temp = rechnung.split("[0-9]|[+]|[-]");

        Iterator<String> it = Arrays.stream(temp).iterator();
        while (it.hasNext()){
            String s=it.next();
            switch (s){
                case "+":
                    erg+=Integer.parseInt(it.next());
                    break;
                case "-":
                    erg-=Integer.parseInt(it.next());
                    break;
                default:
                    erg=Integer.parseInt(s);
                    break;
            }
        }
        return new Rechnung(rechnung,erg);
    }

    public Image castNewImage(int i){
        InputStream ips = getClass().getResourceAsStream("/dice/"+i+".png");
        return new Image(ips);
    }

    public void reset(){
        if (model.getCounter() == 0){
            Random r = new Random();
            int i = r.nextInt(6)+1;
            view.enableW(1);
            view.setImgW1(castNewImage(i));
            valW1=i;
            i = r.nextInt(6)+1;

            view.enableW(2);
            view.setImgW2(castNewImage(i));
            valW2=i;
            i = r.nextInt(6)+1;

            view.enableW(3);
            view.setImgW3(castNewImage(i));
            valW3=i;

            model.setCounter(3);
            model.add(rechner());
            rechnung="";
            view.updateErgTA(model.toString());
        }
    }

    private void ini(){
        if (type.equals("firstCast")){
            Random r = new Random();
            int i = r.nextInt(6)+1;
            view.setImgW1(castNewImage(i));
            valW1=i;
            i = r.nextInt(6)+1;


            view.setImgW2(castNewImage(i));
            valW2=i;
            i = r.nextInt(6)+1;


            view.setImgW3(castNewImage(i));
            valW3=i;
            model.setCounter(3);
        }
    }

}
