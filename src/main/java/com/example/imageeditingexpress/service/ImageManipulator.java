package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.controller.ImageEditingExpressController;
import com.example.imageeditingexpress.model.Brush;
import com.example.imageeditingexpress.model.Effects;
import com.example.imageeditingexpress.util.ImageRotator;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ImageManipulator {
    @FXML
    private ImageView imageView;
    private Canvas canvas;
    private ImageRotator imageRotator;
    private Effects effects;
    private Brush brush;

    public ImageManipulator(ImageView imageView, Canvas canvas) {
        this.imageView = imageView;
        this.canvas = canvas;
        this.imageRotator = new ImageRotator(imageView, canvas);
        this.effects = new Effects();
        this.brush = new Brush(this.canvas);
        imageView.setEffect(effects.getEffectsForImageView());
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
    public void handlePaintEvent(MouseEvent mouseEvent, CheckBox useBrush) {
        if(useBrush.isSelected()){
            canvas.setOnMouseDragged(mouse -> {
                brush.paint(mouse.getX(), mouse.getY());
                mouse.consume();
            });
        }
    }
    public void clearPaint() {
        brush.clearAll();
    }

    public void handlePaintBrushResize(Slider brushSize) {
        brushSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            brush.setSize(newValue.doubleValue());
        });

    }
}
