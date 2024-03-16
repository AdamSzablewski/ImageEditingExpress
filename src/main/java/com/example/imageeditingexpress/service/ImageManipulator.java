package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.model.Effects;
import com.example.imageeditingexpress.util.ImageRotator;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageManipulator {
    @FXML
    private ImageView imageView;
    private ImageRotator imageRotator;
    private Effects effects;


    public ImageManipulator(ImageView imageView) {
        this.imageView = imageView;
        this.imageRotator = new ImageRotator();
        this.effects = new Effects();
    }


    public void setImageView(ImageView imageView){
        this.imageView = imageView;
        this.imageRotator.setImageView(imageView);
        this.imageView.setEffect(effects.getEffectsForImageView());
    }
    public void handleSaturationChange(Slider saturationSlideBar) {
        saturationSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeSaturation(newValue.doubleValue());
        });
    }
    public void handleBrightnessChange(Slider brightnessSlideBar) {
        brightnessSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeBrightness(newValue.doubleValue());
        });
    }
    public void handleContrastChange(Slider contrastSlideBar) {
        contrastSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeContrast(newValue.doubleValue());
        });
    }
    public void handleHueChange(Slider hueSlideBar) {
        hueSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeHue(newValue.doubleValue());
        });
    }
    public void handleBloomChange(Slider bloomSlideBar) {
        bloomSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeBloom(newValue.doubleValue());
        });
    }
    public void handleBlurChange(Slider blurSlider) {
        blurSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeGaussianBlur(blurSlider.valueProperty());
        });

    }
    public void handleMotionBlurChange(Slider motionSlideBar) {
        motionSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            effects.changeMotionBlur(motionSlideBar.valueProperty());
        });

    }
    public void rotateLeft() {
        imageRotator.rotateLeft();
    }
    public void rotateRight() {
        imageRotator.rotateRight();
    }



}
