package com.example.imageeditingexpress.controller;

import com.example.imageeditingexpress.service.ImageSaver;
import com.example.imageeditingexpress.service.ImageManipulator;
import com.example.imageeditingexpress.service.ImageZoomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import lombok.Getter;

import java.io.File;
@Getter
public class ImageEditingExpressController {
    public Button rotateLeftBtn;
    public Button rotateRightBtn;
    public Slider blurSlideBar;
    public Slider motionSlideBar;
    public Slider bloomSlideBar;
    public ColorPicker brushColor;
    public CheckBox useBrush;
    @FXML
    public Canvas canvas;
    public Button clearPaintButton;

    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageView;
    @FXML
    private Slider saturationSlideBar;
    @FXML
    private Slider brightnessSlideBar;
    @FXML
    private Slider hueSlidingBar;
    @FXML
    private Slider contrastSlidingBar;
    private ImageZoomer imageZoomer;
    private Image image;
    private final ImageSaver imageCreator = new ImageSaver();
    private ImageManipulator imageManipulator;
    private static ImageEditingExpressController instance;

    public ImageEditingExpressController(){
        if (instance == null){
            instance = this;
            this.imageManipulator = new ImageManipulator(imageView);
            this.imageZoomer = new ImageZoomer();
        }else {
            throw new IllegalStateException("Instance already exists");
        }
    }
    public static ImageEditingExpressController getInstance() {
        if (instance == null) {
            instance = new ImageEditingExpressController();
        }
        return instance;
    }

    @FXML
    public void initialize() {
        instance = this;

//        canvas.setHeight(imageView.getImage().getHeight());
//        canvas.setWidth(imageView.getImage().getWidth());
        canvas.setStyle("-fx-background-color: transparent;");

        imageManipulator = new ImageManipulator(imageView, canvas);
        //imageManipulator.setImageView(imageView);
        imageCreator.setImageView(imageView);
        imageZoomer = new ImageZoomer(imageView, canvas);
        imageManipulator.handleSaturationChange(saturationSlideBar);
        imageManipulator.handleBrightnessChange(brightnessSlideBar);
        imageManipulator.handleHueChange(hueSlidingBar);
        imageManipulator.handleContrastChange(contrastSlidingBar);
        imageManipulator.handleBlurChange(blurSlideBar);
        imageManipulator.handleBloomChange(bloomSlideBar);
        imageManipulator.handleMotionBlurChange(motionSlideBar);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void handleOpenFile(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imageView.setFitHeight(image.getHeight());
            imageView.setFitWidth(image.getWidth());
            canvas.setHeight(imageView.getImage().getHeight());
            canvas.setWidth(imageView.getImage().getWidth());
        }
    }

    public void handleRotateLeft(ActionEvent actionEvent) {
        imageManipulator.rotateLeft();
    }

    public void handleRotateRight(ActionEvent actionEvent) {
        imageManipulator.rotateRight();
    }

    public void handleSaveAs(ActionEvent actionEvent) {
        try {
            imageCreator.saveImage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleZoomIn(ActionEvent actionEvent) {
        imageZoomer.zoomIn();
    }

    public void handleZoomOut(ActionEvent actionEvent) {
        imageZoomer.zoomOut();
    }

    public void handlePaintDrag(MouseEvent mouseEvent) {
        imageManipulator.handlePaintEvent(mouseEvent, brushColor, useBrush);
    }

    public void clearPaint(ActionEvent actionEvent) {
        imageManipulator.clearPaint();
    }
}