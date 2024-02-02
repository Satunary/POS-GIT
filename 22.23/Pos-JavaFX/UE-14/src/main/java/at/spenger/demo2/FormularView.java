package at.spenger.demo2;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class FormularView extends FlowPane {
    private TextField inPut;
    private Integer caps;
    private ArrayList<String> bgAlph;
    private ArrayList<String> smAlph;
    private ArrayList<String> enterSafe;

    public FormularView(){
        super(Orientation.HORIZONTAL,10,10);
        bgAlph=new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        smAlph=new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
        enterSafe=new ArrayList<>();
        caps=0;
        init();
    }
    private void init(){
        inPut = new TextField();


        Button cap = new Button("Caps");
        cap.setOnAction(event -> {
                    if (caps==2){
                        caps=0;
                    }else {
                        caps++;
                    }
                }
        );


        for(Integer ini=0;ini<26;ini++){
            Button n = new Button(bgAlph.get(ini));
            Integer finalIni = ini;
            n.setOnAction(event -> {
                        switch (caps){
                            case 0:
                                inPut.setText(inPut.getText()+smAlph.get(finalIni));
                                break;
                            case 1:
                                inPut.setText(inPut.getText()+bgAlph.get(finalIni));
                                caps--;
                                break;
                            case 2:
                                inPut.setText(inPut.getText()+bgAlph.get(finalIni));
                                break;
                            default:
                                throw new IllegalArgumentException("something went wrong");
                        }
                    }
            );
            this.getChildren().add(n);
        }
        Button enter = new Button("ENTER");
        enter.setOnAction(eventvent -> {
            enterSafe.add(inPut.getText());
            inPut.setText("");
        });

        Button safe = new Button("SAFE");
        safe.setOnAction(event -> {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new FileWriter("./src/main/java/TextOut"));
                pw.println(inPut.getText());
                inPut.setText("");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }finally {
                if (pw!=null){
                    pw.flush();
                    pw.close();
                }
            }
        });

        this.getChildren().add(cap);
        this.getChildren().add(safe);
        this.getChildren().add(inPut);
        this.getChildren().add(enter);
    }
}
