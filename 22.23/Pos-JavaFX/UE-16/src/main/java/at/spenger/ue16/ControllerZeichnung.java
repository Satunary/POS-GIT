package at.spenger.ue16;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.io.*;

public class ControllerZeichnung implements EventHandler<ActionEvent> {
    private ViewZeichnung view;
    private Zeichnung model;
    private String act;

    public ControllerZeichnung(Zeichnung model, ViewZeichnung view, String act) {
        this.view = view;
        this.model = model;
        this.act=act;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        switch (act){
            case "input":
                model.addFig(model.implement(view.getTfInput()));
                model.drawLast(view);
                view.clearTfInput();
                break;
            case "load":
                read(view.getTfInput());
                model.drawAllNew(view);
                view.clearTfInput();

                break;
            case "save":
                model.save(new File(view.getTfInput()));
                break;
            case "remove":
                view.getGc().clearRect(0,0, view.getCenter().getBoundsInLocal().getHeight(), view.getCenter().getBoundsInLocal().getWidth());
                model.clearAll();
                break;
            default:
                System.out.println("No Good");
        }

    }

    private void read(String path){
            BufferedReader br=null;
            try {
                br = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
            }
            if (br!=null){
                try {
                    String s="";
                    while ((s=br.readLine())!=null){
                        try {
                            model.addFig(model.implement(s));
                        }catch (IllegalArgumentException e){
                            System.out.println("Already exists");
                        }

                    }
                } catch (IOException e) {
                    System.out.println("Not Right");

                }
            }
    }



}
