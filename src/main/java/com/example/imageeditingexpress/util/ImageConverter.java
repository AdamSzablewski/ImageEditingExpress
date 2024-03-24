package com.example.imageeditingexpress.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class ImageConverter {
    public static Image convertAWTImageToFXImage(BufferedImage image){
        return SwingFXUtils.toFXImage(image, null);
    }
}
