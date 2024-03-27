package com.example.imageeditingexpress.model;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Browser {
    Desktop desktop  =  Desktop.getDesktop();

    public void goToGitHub(){
        try {
            desktop.browse(new URI("https://github.com/AdamSzablewski/ImageEditingExpress"));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
