package com.example.imageeditingexpress.ui;

import com.example.imageeditingexpress.config.DesignConfig;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;

import java.io.IOException;
@Data
public class MainPage {
    public static MainPage instance;
    private Parent root;
    public MainPage(){
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
        instance = this;
    }
    public static MainPage getInstance(){
        if (instance != null){
            return instance;
        }else {
            throw new IllegalStateException("Instance not created yet");
        }
    }
    public void open(Stage stage, FXMLLoader fxmlLoader, int width, int height) throws IOException {
        Parent root = fxmlLoader.load();
        this.root = root;
        Scene scene = new Scene(root, width, height);

        stage.setTitle("ImageEditingExpress");
        stage.setScene(scene);
        stage.show();
    }
}
