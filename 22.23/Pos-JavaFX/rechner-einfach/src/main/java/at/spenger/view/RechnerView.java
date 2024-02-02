package at.spenger.view;



import at.spenger.controller.RechnerController;
import at.spenger.model.RechnerModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;


public class RechnerView extends BorderPane {
    private TextField tfErgebnis;
    private TextField tfWert1;
    private TextField tfWert2;
    private Label info;
    private ComboBox<String> cbOperation;

    private RechnerController controller;
    private RechnerModel model;



    public RechnerView() {
        // In dieser Loesung: View erzeugt Model
        model = new RechnerModel();
        controller = new RechnerController(model, this);
        initGui();
    }


    private void initGui() {
        this.setCenter(erzeugeFormular());

        info = new Label("");
        info.setMaxWidth(Double.MAX_VALUE);
        info.setTextFill(Color.RED);
        info.setAlignment(Pos.CENTER);

        this.setBottom(info);
    }

    public void setInfo(String s) {
        info.setText(s);
    }

    private Pane erzeugeFormular() {
        GridPane pane = new GridPane();
        //pane.setGridLinesVisible(true);
        pane.setVgap(5);
        pane.setHgap(5);
        pane.setPadding(new Insets(10));

        // Grid width
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setPercentWidth(25);
        ColumnConstraints cc2 = new ColumnConstraints();
        cc2.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(
                cc1,
                cc2
                );

        // First row
        Label lbl = new Label("Wert 1:");
        pane.add(lbl, 0, 0);

        tfWert1 = new TextField();
        pane.add(tfWert1, 1, 0);

        // Second row
        pane.add(new Label("Wert 2:"), 0, 1);

        tfWert2 = new TextField();
        pane.add(tfWert2, 1, 1);

        // Third row
        cbOperation = new ComboBox<>();
        cbOperation.setMaxWidth(Double.MAX_VALUE);
//        var observableList = FXCollections.observableList(new ArrayList<>(List.of("Plus", "Minus")));
//        ops.setItems(observableList);
        cbOperation.getItems().addAll("Plus", "Minus");
        cbOperation.setValue("Plus");
        pane.add(cbOperation, 0, 2, 2, 1);

        // 4th row
        Button btn = new Button("Rechne");
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setOnAction(controller);
        pane.add(btn, 0, 3, 2, 1);

        // 5th row
        pane.add(new Label("Ergebnis:"), 0, 4);

        tfErgebnis = new TextField();
        tfErgebnis.setEditable(false);
        pane.add(tfErgebnis, 1, 4);

        return pane;
    }

    public String getWert1() {
        return tfWert1.getText();
    }

    public String getWert2() {
        return tfWert2.getText();
    }

    public String getOperator() {
        return cbOperation.getValue();
    }

    public void update() {
        tfErgebnis.setText("%.2f".formatted(model.getErg()));
    }


}
