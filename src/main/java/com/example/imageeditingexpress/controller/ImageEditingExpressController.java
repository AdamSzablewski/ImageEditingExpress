package com.example.imageeditingexpress.controller;

import com.example.imageeditingexpress.config.DesignConfig;
import com.example.imageeditingexpress.model.FileSize;
import com.example.imageeditingexpress.service.*;
import com.example.imageeditingexpress.ui.FileResizeWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.stage.FileChooser;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
@Getter
@Setter
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
    public Label imageSize;
    public Label fileName;
    public Slider brushSize;

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
    private FileSize fileSize;
    private File mainImageFile;
    private Image image;
    private ImageCombiner imageCombiner;
    private ImageSaver imageSaver;
    private ImageManipulator imageManipulator;
    private static ImageEditingExpressController instance;

    public ImageEditingExpressController() {
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already exists");
        }
        instance = this;
    }

    public static ImageEditingExpressController getInstance() {
        if (instance == null) {
            instance = new ImageEditingExpressController();
        }
        return instance;
    }
//    public ImageEditingExpressController(){
//        if (instance == null){
//            instance = this;
//        }else {
//            throw new IllegalStateException("Instance already exists");
//        }
//    }
//    public static ImageEditingExpressController getInstance() {
//        if (instance == null) {
//            instance = new ImageEditingExpressController();
//        }
//        return instance;
//    }

    @FXML
    public void initialize() {
        imageSize.setText(null);
        fileName.setText(null);
        DesignConfig.setCanvasStyle(canvas, "-fx-background-color: transparent;");
        this.imageManipulator = new ImageManipulator(imageView, canvas);
        imageCombiner = new ImageCombiner(imageView, canvas);
        imageSaver = new ImageSaver();
        this.imageZoomer = new ImageZoomer(imageView, canvas);
        startListners();
    }

    private void  startListners(){
        imageManipulator.handleSaturationChange(saturationSlideBar);
        imageManipulator.handleBrightnessChange(brightnessSlideBar);
        imageManipulator.handleHueChange(hueSlidingBar);
        imageManipulator.handleContrastChange(contrastSlidingBar);
        imageManipulator.handleBlurChange(blurSlideBar);
        imageManipulator.handleBloomChange(bloomSlideBar);
        imageManipulator.handleMotionBlurChange(motionSlideBar);
        imageManipulator.handlePaintBrushResize(brushSize);

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void handleOpenFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            mainImageFile = selectedFile;
            fileName.setText(selectedFile.getName());
            imageSize.setText(FileSize.getFileSizeMB(mainImageFile)+" MB");
            image = new Image(selectedFile.toURI().toString());
            configureImageView(image);
        }
    }
    public void configureImageView(Image image){
        imageView.setImage(image);
        imageView.setFitHeight(image.getHeight());
        imageView.setFitWidth(image.getWidth());
        canvas.setHeight(imageView.getImage().getHeight());
        canvas.setWidth(imageView.getImage().getWidth());
    }

    public void handleRotateLeft(ActionEvent actionEvent) {
        imageManipulator.rotateLeft();
    }

    public void handleRotateRight(ActionEvent actionEvent) {
        imageManipulator.rotateRight();
    }

    public void handleSaveAs(ActionEvent actionEvent) {
        try {
            imageCombiner.setImageView(imageView);
            imageCombiner.setCanvas(canvas);
            imageSaver.saveImage(imageCombiner.getCombinedView());

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
        imageManipulator.handlePaintEvent(mouseEvent, useBrush);
    }

    public void clearPaint(ActionEvent actionEvent) {
        imageManipulator.clearPaint();
    }

    public void zoom(ZoomEvent zoomEvent) {
        imageZoomer.zoomFromZoomEvent(zoomEvent);
    }

    public void undoAll(ActionEvent actionEvent) {
        imageManipulator = new ImageManipulator(imageView, canvas);
    }

    public void cut(ActionEvent actionEvent) {
    }

    public void resizeImage(ActionEvent actionEvent) {


    }

    public void resizeToMbSize(ActionEvent actionEvent) {
        FileResizeWindow window = new FileResizeWindow();
        window.createWindowMB();
    }
}