module com.example.logik {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.logik to javafx.fxml;
    exports com.example.logik;
}