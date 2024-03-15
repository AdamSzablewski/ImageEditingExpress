module com.example.imageeditingexpress {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.imageeditingexpress to javafx.fxml;
    exports com.example.imageeditingexpress;
    exports com.example.imageeditingexpress.controller;
    opens com.example.imageeditingexpress.controller to javafx.fxml;
}