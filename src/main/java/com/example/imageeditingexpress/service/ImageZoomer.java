package com.example.imageeditingexpress.service;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ImageZoomer {
    private ImageView imageView;
    private Canvas canvas;
    private double currentZoom = 1.0;
    private double zoomIntensity = 0.1;

    public ImageZoomer(ImageView imageView, Canvas canvas) {
        this.imageView = imageView;
        this.canvas = canvas;
    }
    public void updateZoom(){
        imageView.setScaleX(currentZoom);
        imageView.setScaleY(currentZoom);
        canvas.setScaleX(currentZoom);
        canvas.setScaleY(currentZoom);

    }
    public void updateZoom(ImageView imageView){
        if(currentZoom < 0){
            imageView.setScaleX(0.1);
            imageView.setScaleY(0.1);
        }else {
            imageView.setScaleX(currentZoom);
            imageView.setScaleY(currentZoom);
        }
    }

    public void zoomIn() {
        currentZoom += zoomIntensity;
        updateZoom();
    }

    public void zoomOut() {
        currentZoom -= zoomIntensity;
        updateZoom();
    }
    public void zoomToDefault(ImageView imageView){
        currentZoom = 1;
        updateZoom(imageView);
    }

}
