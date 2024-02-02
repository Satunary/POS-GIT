package at.spenger.ue16;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class ViewZeichnung extends BorderPane {
    private TextField tfInput;
    private Zeichnung model;
    private ControllerZeichnung controller;
    private Pane top;
    private GraphicsContext gc;
    private Canvas canvas;

    private Label info;
    public ViewZeichnung(){
        canvas = new Canvas(700,430);
        gc=canvas.getGraphicsContext2D();
        this.setCenter(canvas);
        top=new Pane();
        model=new Zeichnung();
        controller=new ControllerZeichnung(model,this,"");
        initGui();
    }

    public void initGui(){

        Label lbl0 = new Label();
        lbl0.setText("Figur: ");
        lbl0.setPrefWidth(50);
        lbl0.setPrefHeight(20);
        lbl0.setLayoutX(0);
        lbl0.setLayoutY(0);


        tfInput = new TextField();
        tfInput.setPrefWidth(150);
        tfInput.setLayoutX(50);
        tfInput.setLayoutY(0);


        Button btnInp = new Button("Einfügen");
        btnInp.setOnAction(new ControllerZeichnung(model,this,"input"));
        btnInp.setLayoutX(200);
        btnInp.setLayoutY(0);
        btnInp.setPrefWidth(70);

        Button btnSave = new Button("Speichern");
        btnSave.setOnAction(new ControllerZeichnung(model,this,"save"));
        btnSave.setLayoutX(272);
        btnSave.setLayoutY(0);

        Button btnLoad = new Button("Laden");
        btnLoad.setOnAction(new ControllerZeichnung(model,this,"load"));
        btnLoad.setLayoutX(342);
        btnLoad.setLayoutY(0);

        Button btnDel = new Button("Löschen");
        btnDel.setOnAction(new ControllerZeichnung(model,this,"remove"));
        btnDel.setLayoutX(392);
        btnDel.setLayoutY(0);
        top.getChildren().addAll(lbl0,tfInput,btnInp,btnLoad,btnSave,btnDel);
        this.setTop(top);

        info = new Label();

        info.setText("Input structure: Typ (With Height)/Radius x y color or a filepath with inputs of the same structure\n for save please input a filepath");
        info.setMaxWidth(Double.MAX_VALUE);
        info.setTextFill(Color.GREEN);
        info.setAlignment(Pos.CENTER);
        this.setBottom(info);
    }
    public void setInfo(String s){
        info.setText(s);
    }

    public String getTfInput(){
        return tfInput.getText();
    }
    public void clearTfInput(){
        tfInput.setText("");
    }

    public Canvas getCanvas(){return canvas;}

    public GraphicsContext getGc() {
        return gc;
    }
}
