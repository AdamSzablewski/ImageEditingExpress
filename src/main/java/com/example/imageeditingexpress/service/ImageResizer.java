package com.example.imageeditingexpress.service;

import com.example.imageeditingexpress.controller.ImageEditingExpressController;

import com.example.imageeditingexpress.model.FileSize;
import com.example.imageeditingexpress.util.ImageConverter;
import com.example.imageeditingexpress.util.ValueConverter;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizer {

    public Image resizeImageToSize(File file, int desiredSize){
        File mainImageFile = ImageEditingExpressController.getInstance().getMainImageFile();
        FileSize fileSize = new FileSize();
        double currentSize = fileSize.getFileSizeMB(mainImageFile);
        Image originalImage = ImageEditingExpressController.getInstance().getImage();
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            double multiplyer = (double) desiredSize / currentSize;
            int newWidth = (int) (originalImage.getWidth() * multiplyer);
            int newHeight = (int) (originalImage.getHeight() * multiplyer);

            return convertAWTImageToFX(resizeAWTImage(bufferedImage, newWidth, newHeight));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedImage resizeAWTImage(BufferedImage awtImage, int targetWidth, int targetHeight) {
        java.awt.Image scaledImage = awtImage.getScaledInstance(targetWidth, targetHeight, java.awt.Image.SCALE_DEFAULT);
        BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(scaledImage, 0, 0, null);
        return bufferedImage;
    }
    public static Image convertAWTImageToFX(BufferedImage bufferedImage){
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }

}
