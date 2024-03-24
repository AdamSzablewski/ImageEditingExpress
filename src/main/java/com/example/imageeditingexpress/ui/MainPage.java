package com.example.imageeditingexpress.ui;

import com.example.imageeditingexpress.config.DesignConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage {


    public void open(Stage stage, FXMLLoader fxmlLoader, int width, int height) throws IOException {
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, width, height);

        stage.setTitle("ImageEditingExpress");
        stage.setScene(scene);
        stage.show();
    }
}
