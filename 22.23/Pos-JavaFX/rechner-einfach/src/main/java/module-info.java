module at.spenger {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger to javafx.fxml;
    exports at.spenger;
}