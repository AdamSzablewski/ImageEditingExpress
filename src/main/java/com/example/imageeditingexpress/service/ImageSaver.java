package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.model.ImageSettings;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaver {

    private ImageView imageView;


    public void saveImage(ImageSettings imageSettings){
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(primaryStage);
        System.out.println(file.getAbsolutePath());
        if (file != null) {
            setImageViewZoomToDefault(imageView);
            WritableImage image = imageView.snapshot(null, null);
            System.out.println("Snapshot image width: " + image.getWidth());
            System.out.println("Snapshot image height: " + image.getHeight());
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            try {
                boolean ok = ImageIO.write(bufferedImage, "png", new File("/Users/adamszablewski/Downloads/testing.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void setImageViewZoomToDefault(ImageView imageView){
        ImageZoomer imageZoomer = new ImageZoomer();
        imageZoomer.zoomToDefault(imageView);
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
