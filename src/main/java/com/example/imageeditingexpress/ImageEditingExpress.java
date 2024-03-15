package com.example.imageeditingexpress;

import com.example.imageeditingexpress.model.MainPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImageEditingExpress extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ImageEditingExpress.class.getResource("main.fxml"));
        MainPage mainPage = new MainPage();
        mainPage.open(stage, fxmlLoader, 800, 500);
//        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
//        stage.setTitle("ImageEditingExpress");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}