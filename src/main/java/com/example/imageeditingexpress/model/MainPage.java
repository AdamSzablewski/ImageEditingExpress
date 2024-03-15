package com.example.imageeditingexpress.model;

import com.example.imageeditingexpress.config.DesignConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage {


    public void open(Stage stage, FXMLLoader fxmlLoader, int width, int height) throws IOException {
        DesignConfig designConfig = new DesignConfig();
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, width, height);
        designConfig.setTextColorToWhite(root, scene);
        stage.setTitle("ImageEditingExpress");
        stage.setScene(scene);
        stage.show();
    }
}
