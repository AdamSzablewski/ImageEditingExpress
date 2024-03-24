package com.example.imageeditingexpress.controller;

import com.example.imageeditingexpress.service.ImageResizer;
import com.example.imageeditingexpress.util.Validator;
import com.example.imageeditingexpress.util.ValueConverter;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import lombok.Data;

import java.io.File;

@Data
public class ImageResizeController {


    public TextField desiredSizeField;
    public ImageEditingExpressController imageEditingExpressController = ImageEditingExpressController.getInstance();


    public void resizeImage(ActionEvent actionEvent) {
        ImageResizer imageResizer = new ImageResizer();
        ValueConverter valueConverter = new ValueConverter();
        Validator validator = new Validator();
        File image = imageEditingExpressController.getMainImageFile();
        String requestedSizeText = desiredSizeField.getText();
        if(validator.validateNumeric(requestedSizeText)){
            int mb = valueConverter.convertStringToInt(requestedSizeText);
            Image resizedImage = imageResizer.resizeImageToSize(image, mb);
            imageEditingExpressController.setImage(resizedImage);
        }

    }
}
