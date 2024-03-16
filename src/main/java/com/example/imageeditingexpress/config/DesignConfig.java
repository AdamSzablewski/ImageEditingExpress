package com.example.imageeditingexpress.config;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class DesignConfig {

    public void setTextColorToWhite(Parent root, Scene scene){
        MenuBar menuBar = (MenuBar) root.lookup("#menuBar");

        for (Menu menu : menuBar.getMenus()) {
            menu.setStyle("-fx-text-fill: white;");
            System.out.println("done");
        }
    }
}
