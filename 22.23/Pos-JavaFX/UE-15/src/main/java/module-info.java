module at.spenger.ue15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger.ue15 to javafx.fxml;
    exports at.spenger.ue15;
}