module at.spenger.projekt1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger.projekt1 to javafx.fxml;
    exports at.spenger.projekt1;
}