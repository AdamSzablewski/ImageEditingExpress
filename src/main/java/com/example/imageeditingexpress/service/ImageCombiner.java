package com.example.imageeditingexpress.service;

import javafx.scene.Group;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageCombiner {
    private ImageView imageView;
    private Canvas canvas;
    public ImageCombiner(ImageView imageView, Canvas canvas) {
        this.imageView = imageView;
        this.canvas = canvas;
    }
    public ImageView getCombinedView(){
        ImageZoomer imageZoomer = new ImageZoomer(imageView, canvas);
        imageZoomer.zoomToDefault();
        Group group = new Group(imageView, canvas);

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(null);
        WritableImage combinedImage = new WritableImage(
                (int) imageView.getBoundsInParent().getWidth(),
                (int) imageView.getBoundsInParent().getHeight());
        group.snapshot(params, combinedImage);
        return new ImageView(combinedImage);
    }
}
