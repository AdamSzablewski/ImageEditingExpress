package com.example.imageeditingexpress.model;

import javafx.beans.property.DoubleProperty;
import javafx.scene.effect.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Effects {

    private ColorAdjust colorAdjust;
    private GaussianBlur gaussianBlur;
    private Bloom bloom;
    private MotionBlur motionBlur;

    public Effects() {
        this.colorAdjust = new ColorAdjust();
        this.gaussianBlur = new GaussianBlur(0);
        this.bloom = new Bloom(1);
        this.motionBlur = new MotionBlur();
        this.motionBlur.setRadius(0);
    }
    public Effect getEffectsForImageView(){
        bloom.setInput(motionBlur);
        gaussianBlur.setInput(bloom);
        colorAdjust.setInput(gaussianBlur);
        return colorAdjust;
    }
    public void changeGaussianBlur(DoubleProperty valueProperty) {
        gaussianBlur.radiusProperty().bind(valueProperty);
    }
    public void changeMotionBlur(DoubleProperty valueProperty) {
        motionBlur.radiusProperty().bind(valueProperty);
    }
    public void changeBloom(double value) {
        bloom.setThreshold(value);
    }
    public void changeSaturation(double value){
        colorAdjust.setSaturation(value);
    }
    public void changeHue(double value){
        colorAdjust.setHue(value);
    }
    public void changeBrightness(double value){
        colorAdjust.setBrightness(value);
    }
    public void changeContrast(double value){
        colorAdjust.setContrast(value);
    }

}
