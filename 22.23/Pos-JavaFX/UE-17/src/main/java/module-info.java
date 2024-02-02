module speng.at.ue17 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens speng.at.ue17 to javafx.fxml;
    exports speng.at.ue17;
}