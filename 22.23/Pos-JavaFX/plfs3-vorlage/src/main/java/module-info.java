module at.spenger.plfs3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger.plfs3 to javafx.fxml;
    exports at.spenger.plfs3;
}