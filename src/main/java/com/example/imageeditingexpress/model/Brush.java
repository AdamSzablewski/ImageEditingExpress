package com.example.imageeditingexpress.model;

import com.example.imageeditingexpress.controller.ImageEditingExpressController;
import com.example.imageeditingexpress.ui.MainPage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Brush {
    private GraphicsContext graphicsContext;
    private ColorPicker color;
    private Canvas canvas;
    private double width;
    private Circle brush;
    private double height;
    private boolean isVisible;



    public Brush(Canvas canvas) {
        this.canvas = canvas;
        this.width = 40;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.color = ImageEditingExpressController.getInstance().getBrushColor();
        this.brush = ImageEditingExpressController.getInstance().getBrush();
    }

    public void setSize(double multiplier) {
        width = multiplier;
        height = multiplier;
        brush.setRadius(2 * width);
    }
    public void paint(double x, double y){
        graphicsContext.setFill(color.getValue());
        graphicsContext.fillOval(x, y, brush.getRadius()*8, brush.getRadius()*8);
    }


    public void clearAll() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    public void showBrush(boolean show){
        if (show && !brush.isVisible()){
            brush.setVisible(true);
        }
        else{
            brush.setVisible(false);
        }
    }

    public void move(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();
        double localX = canvas.getLayoutX();
        double localY = canvas.getLayoutY();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        double coordX;
        double coordY;
        if (mouseX > localX && mouseX < localX + canvasWidth){
            coordX = mouseX;
        }else {
            coordX = localX + 1;
        }
        if (mouseY > localY && mouseY < localY + canvasHeight){

            coordY = mouseY;
        }else {
            coordY = localY + 1;
        }
        brush.setLayoutX(coordX);
        brush.setLayoutY(coordY);
    }

    public void moveToCenter() {

        double localX = canvas.getLayoutX();
        double localY = canvas.getLayoutY();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();

        double coordX = (localX + canvasWidth) / 2;
        double coordY =  (localY + canvasHeight) / 2;
        brush.setLayoutX(coordX);
        brush.setLayoutY(coordY);
    }
}
