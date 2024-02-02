package at.spenger.controller;



import at.spenger.model.RechnerModel;
import at.spenger.view.RechnerView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RechnerController implements EventHandler<ActionEvent> {
    private RechnerView view;
    private RechnerModel model;

    public RechnerController(RechnerModel model, RechnerView view) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Hallo");
        view.setInfo("");

        var w1 = 0.0;
        var w2 = 0.0;

        String errorTextfield = "";
/*
        try {
            errorTextfield = view.getWert1();
            w1 = Double.parseDouble(view.getWert1());
            errorTextfield = view.getWert2();
            w2 = Double.parseDouble(view.getWert2());
        } catch(Exception e) {
            view.setInfo("Geben Sie statt %s bitte eine Zahlen ein!".formatted(errorTextfield));
        }
*/
        try {
            errorTextfield = view.getWert1();
            w1 = Double.parseDouble(view.getWert1());
            errorTextfield = "";
        } catch(Exception e) {
            view.setInfo("Geben Sie statt %s bitte eine Zahlen ein!".formatted(view.getWert1()));
            return;
        }

        try {
            w2 = Double.parseDouble(view.getWert2());
        } catch(Exception e) {
            if(errorTextfield.isEmpty()) {
                view.setInfo("Geben Sie statt %s bitte eine Zahlen ein!".formatted(view.getWert2()));
            } else {
                view.setInfo("Geben Sie statt %s und %s bitte Zahlen ein!".formatted(errorTextfield, view.getWert2()));
            }
            return;
        }

        double erg = 0;
        String operation = view.getOperator();
        switch (operation) {
            case "Plus":
                erg = model.add(w1, w2);
                break;
            case "Minus":
                erg = model.sub(w1, w2);
                break;
            default:
                view.setInfo("Geben Sie bitte einen Operator an!");
        }

        // Merken der Operationen, nur zum Spass ...
        model.add("Operation: %s %s %s".formatted(
                view.getWert1(),
                view.getOperator(),
                view.getWert2()
        ));

        // In dieser Loessung: View wird von Control ueber Aenderung informiert.
        // Alternative: Das Model teilt dem View
        // durch eine Nachricht mit, dass es geaendert wurde.
        view.update();
    }




}
