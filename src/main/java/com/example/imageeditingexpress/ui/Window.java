package com.example.imageeditingexpress.ui;

import com.example.imageeditingexpress.ImageEditingExpress;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Window {
    public void createWindow(String fxml, int width, int height, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ImageEditingExpress.class.getResource(fxml));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
