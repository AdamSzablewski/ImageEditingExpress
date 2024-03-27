package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.controller.ImageEditingExpressController;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaver {

    private ImageView imageView;


    public void saveImage(ImageView imageView){
        Stage primaryStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {

            String pathRaw  = file.getPath();
            WritableImage image = imageView.snapshot(null, null);
            BufferedImage bufImageRGB = new BufferedImage((int)image.getWidth(), (int)image.getHeight(), BufferedImage.OPAQUE);
            SwingFXUtils.fromFXImage(image, null).copyData(bufImageRGB.getRaster());
            String format = pathRaw.contains(".png") ? "png" : "jpg";
            int dotIndex = pathRaw.indexOf('.');
            String path = dotIndex != -1 ? pathRaw.substring(0, dotIndex) : pathRaw;
            try {
                boolean ok = ImageIO.write(bufImageRGB, format, new File(path+"."+format));
                if (!ok){
                    throw new RuntimeException("Image not saved");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
