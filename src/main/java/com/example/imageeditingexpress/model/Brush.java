package com.example.imageeditingexpress.model;

import com.example.imageeditingexpress.controller.ImageEditingExpressController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Brush {
    private final GraphicsContext graphicsContext;
    private ColorPicker color;
    private Canvas canvas;
    private double width;
    private double height;
    private boolean isVisible;



    public Brush(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.color = ImageEditingExpressController.getInstance().getBrushColor();
    }

    public void setSize(double multiplier) {
        width = 1 * multiplier;
        height = 1 * multiplier;
    }
    public void paint(double x, double y){
        graphicsContext.setFill(color.getValue());
        graphicsContext.fillOval(x - 2, y - 2, width, height);

    }

    public void clearAll() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
