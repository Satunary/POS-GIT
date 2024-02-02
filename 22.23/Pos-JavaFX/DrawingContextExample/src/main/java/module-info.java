module at.spenger {
    requires javafx.controls;
    requires javafx.fxml;

    exports at.spenger;
    opens at.spenger to javafx.fxml;
}