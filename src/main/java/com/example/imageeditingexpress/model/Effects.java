package com.example.imageeditingexpress.model;

import javafx.beans.property.DoubleProperty;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Effects {

    private ColorAdjust colorAdjust = new ColorAdjust();
    private GaussianBlur gaussianBlur = new GaussianBlur(0);
    private Blend blend;

    public Effects() {
        Blend blend = new Blend();

        blend.setTopInput(colorAdjust);
        blend.setBottomInput(gaussianBlur);
        this.blend = blend;
    }

    public void changeGaussianBlur(DoubleProperty valueProperty) {
        gaussianBlur.radiusProperty().bind(valueProperty);
    }
}
