package com.example.imageeditingexpress.util;

public class ValueConverter {

    public int convertStringToInt(String text){
        Validator validator = new Validator();
        return Integer.parseInt(text);
    }
}
