package com.example.imageeditingexpress.util;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.CancellationException;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ImageRotator {

    private ImageView imageView;
    private Canvas canvas;
    private final int rotationAngle = 90;

    public void rotateRight(){
        imageView.setRotate(imageView.getRotate() + rotationAngle);
        canvas.setRotate(imageView.getRotate() + rotationAngle);

    }
    public void rotateLeft(){
        imageView.setRotate(imageView.getRotate() - rotationAngle);
        canvas.setRotate(imageView.getRotate() - rotationAngle);

    }
}
