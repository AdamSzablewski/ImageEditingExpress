package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.model.Effects;
import com.example.imageeditingexpress.util.ImageRotator;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.ImageView;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageManipulator {
    private ColorAdjust colorAdjust;
    private GaussianBlur gaussianBlur;
    private Bloom bloom;
    private MotionBlur motionBlur;
    @FXML
    private ImageView imageView;
    private ImageRotator imageRotator;
    private Effects effects;


    public ImageManipulator(ImageView imageView) {
        this.imageView = imageView;
        this.imageRotator = new ImageRotator();
        this.effects = new Effects();
        this.colorAdjust = new ColorAdjust();
        this.gaussianBlur = new GaussianBlur(0);
        this.bloom = new Bloom(0);
        this.motionBlur = new MotionBlur();
    }

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
        this.imageRotator.setImageView(imageView);

        bloom.setInput(motionBlur);
        gaussianBlur.setInput(bloom);
        colorAdjust.setInput(gaussianBlur);
        this.imageView.setEffect(colorAdjust);
    }
    public void handleSaturationChange(Slider saturationSlideBar) {
        saturationSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setSaturation(newValue.doubleValue());
        });
    }
    public void handleBrightnessChange(Slider brightnessSlideBar) {
        brightnessSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setBrightness(newValue.doubleValue());
        });
    }
    public void handleContrastChange(Slider contrastSlideBar) {
        contrastSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setContrast(newValue.doubleValue());
        });
    }
    public void handleHueChange(Slider hueSlideBar) {
        hueSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            colorAdjust.setHue(newValue.doubleValue());
        });
    }
    public void handleBloomChange(Slider bloomSlideBar) {
        bloomSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            bloom.setThreshold(newValue.doubleValue());
        });
    }
    public void handleBlurChange(Slider blurSlider) {
        blurSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            //effects.changeGaussianBlur(blurSlider.valueProperty());
            gaussianBlur.radiusProperty().bind(blurSlider.valueProperty());
        });

    }
    public void handleMotionBlurChange(Slider motionSlideBar) {
        motionSlideBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            //effects.changeGaussianBlur(blurSlider.valueProperty());
            motionBlur.radiusProperty().bind(motionSlideBar.valueProperty());
        });

    }
    public void rotateLeft() {
        imageRotator.rotateLeft();
    }
    public void rotateRight() {
        imageRotator.rotateRight();
    }



}
