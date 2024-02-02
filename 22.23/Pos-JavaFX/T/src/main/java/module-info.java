module at.spenger.t {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens at.spenger.t to javafx.fxml;
    exports at.spenger;
}