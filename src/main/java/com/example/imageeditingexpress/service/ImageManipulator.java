package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.model.ImageSettings;
import com.example.imageeditingexpress.util.ImageRotator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.ResourceBundle;

@NoArgsConstructor
public class ImageManipulator {
    private ColorAdjust colorAdjust;
    @FXML
    private ImageView imageView;
    private ImageSettings imageSettings;
    private ImageRotator imageRotator;


    public ImageManipulator(ImageView imageView, ImageSettings imageSettings) {
        this.imageView = imageView;
        this.imageSettings = imageSettings;
        this.colorAdjust = new ColorAdjust();
        this.imageRotator = new ImageRotator();
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
        this.imageRotator.setImageView(imageView);
    }


    public void handleSaturationChange(Slider saturationSlideBar) {
        imageView.setEffect(colorAdjust);
        saturationSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setSaturation(newValue.doubleValue());
            imageSettings.setSaturation(newValue.doubleValue());
        });
    }

    public void handleBrightnessChange(Slider brightnessSlideBar) {
        imageView.setEffect(colorAdjust);
        brightnessSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setBrightness(newValue.doubleValue());
            imageSettings.setBrightness(newValue.doubleValue());
        });
    }
    public void handleContrastChange(Slider contrastSlideBar) {
        imageView.setEffect(colorAdjust);
        contrastSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setContrast(newValue.doubleValue());
            imageSettings.setContrast(newValue.doubleValue());
        });
    }
    public void handleHueChange(Slider hueSlideBar) {
        imageView.setEffect(colorAdjust);
        hueSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setHue(newValue.doubleValue());
            imageSettings.setHue(newValue.doubleValue());
        });
    }
    public void rotateLeft() {
        imageRotator.rotateLeft();
    }
    public void rotateRight() {
        imageRotator.rotateRight();
    }

}
