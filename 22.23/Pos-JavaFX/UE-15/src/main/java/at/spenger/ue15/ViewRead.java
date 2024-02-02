package at.spenger.ue15;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewRead extends Pane {
    private TextField datei;
    private BufferedReader br;
    public ViewRead(){
        initGui();

    }

    public void initGui(){
        Label lbl0 = new Label();
        lbl0.setText("Datei: ");
        lbl0.setPrefWidth(50);
        lbl0.setPrefHeight(20);
        lbl0.setLayoutX(0);
        lbl0.setLayoutY(0);


        datei = new TextField();
        datei.setPrefWidth(150);
        datei.setLayoutX(50);
        datei.setLayoutY(0);



        Button run = new Button("Run");
        run.setOnAction(event ->{
            if(br==null){
                try {
                    br = new BufferedReader(new FileReader(datei.getText()));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                String s="";
                while ((s=br.readLine())!=null){
                    implement(s);
                }
            } catch (IOException e) {
                System.out.println("2");
                throw new RuntimeException(e);
            }
        });
        run.setLayoutX(200);
        run.setLayoutY(0);
        run.setPrefWidth(50);

        Button step = new Button("Step");
        step.setOnAction(event ->{
            if(br==null){
                try {
                    br = new BufferedReader(new FileReader(datei.getText()));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            String s="";
            try {
                if ((s=br.readLine())!=null){
                    implement(s);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        step.setLayoutX(250);
        step.setLayoutY(0);
        this.getChildren().addAll(lbl0,datei,run,step);
    }

    private void implement(String s){
        String[] temp = s.split(" ");
        if (temp[0].equals("BUTTON")){
            Button bt = new Button(temp[1]);
            bt.setLayoutX(Double.parseDouble(temp[2]));
            bt.setLayoutY(Double.parseDouble(temp[3]));
            bt.setPrefWidth(Double.parseDouble(temp[4]));
            bt.setPrefHeight(Double.parseDouble(temp[5]));

            this.getChildren().add(bt);
        }

        if (temp[0].equals("LABEL")){
            String [] col1 = temp[6].split("/");
            String [] col2 = temp[7].split("/");
            Label lb = new Label(temp[0]);
            lb.setLayoutX(Double.parseDouble(temp[2]));
            lb.setLayoutY(Double.parseDouble(temp[3]));
            lb.setPrefWidth(Double.parseDouble(temp[4]));
            lb.setPrefHeight(Double.parseDouble(temp[5]));
            lb.setTextFill(Color.rgb(Integer.parseInt(col1[0]),Integer.parseInt(col1[1]),Integer.parseInt(col1[2])));
            lb.setBackground(new Background(new BackgroundFill(Color.rgb(Integer.parseInt(col2[0]), Integer.parseInt(col2[1]), Integer.parseInt(col2[2])), CornerRadii.EMPTY, Insets.EMPTY)));
            this.getChildren().add(lb);
        }

        if (temp[0].equals("TEXTFIELD")){
            TextField tf = new TextField();
            tf.setLayoutX(Double.parseDouble(temp[2]));
            tf.setLayoutY(Double.parseDouble(temp[3]));
            tf.setPrefWidth(Double.parseDouble(temp[4]));
            tf.setPrefHeight(Double.parseDouble(temp[5]));
            this.getChildren().add(tf);
        }
    }
}
