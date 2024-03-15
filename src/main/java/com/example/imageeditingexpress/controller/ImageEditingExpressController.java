package com.example.imageeditingexpress.controller;

import com.example.imageeditingexpress.model.ImageSettings;
import com.example.imageeditingexpress.service.ImageSaver;
import com.example.imageeditingexpress.service.ImageManipulator;
import com.example.imageeditingexpress.service.ImageZoomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import lombok.Getter;

import java.io.File;
@Getter
public class ImageEditingExpressController {
    public Button rotateLeftBtn;
    public Button rotateRightBtn;
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageView;
    @FXML
    private Slider saturationSlideBar;
    @FXML
    private Slider brightnessSlideBar;
    @FXML
    private Slider hueSlidingBar;
    @FXML
    private Slider contrastSlidingBar;
    private ImageZoomer imageViewer = new ImageZoomer();
    private Image image;
    private ImageSettings imageSettings = new ImageSettings();
    private final ImageSaver imageCreator = new ImageSaver();
    private final ImageManipulator imageManipulator = new ImageManipulator(imageView, imageSettings);
    private static ImageEditingExpressController instance;
    public static ImageEditingExpressController getInstance() {
        if (instance == null) {
            instance = new ImageEditingExpressController();
        }
        return instance;
    }

    @FXML
    public void initialize() {
        instance = this;
        imageViewer.setImageView(imageView);
        imageManipulator.setImageView(imageView);
        imageCreator.setImageView(imageView);
        imageManipulator.handleSaturationChange(saturationSlideBar);
        imageManipulator.handleBrightnessChange(brightnessSlideBar);
        imageManipulator.handleHueChange(hueSlidingBar);
        imageManipulator.handleContrastChange(contrastSlidingBar);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void handleOpenFile(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imageView.setFitHeight(image.getHeight());
            imageView.setFitWidth(image.getWidth());
        }
    }

    public void handleRotateLeft(ActionEvent actionEvent) {
        imageManipulator.rotateLeft();
    }

    public void handleRotateRight(ActionEvent actionEvent) {
        imageManipulator.rotateRight();
    }

    public void handleSaveAs(ActionEvent actionEvent) {
        try {
            imageCreator.saveImage(imageSettings);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleZoomIn(ActionEvent actionEvent) {
        imageViewer.zoomIn();
    }

    public void handleZoomOut(ActionEvent actionEvent) {
        imageViewer.zoomOut();
    }
}