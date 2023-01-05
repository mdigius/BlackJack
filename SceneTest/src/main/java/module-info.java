module com.example.scenetest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.scenetest to javafx.fxml;
    exports com.example.scenetest;
}