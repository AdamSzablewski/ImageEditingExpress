package com.example.imageeditingexpress.util;

public class Validator {
    public boolean validateNumeric(String text){
        boolean hadSeparator = false;
        for (char c : text.toCharArray()){
            if ((!Character.isDigit(c) || c !=',' || c != '.') && hadSeparator){
                return false;
            }else if(c == '.' || c == '.'){
                hadSeparator = true;
            }
        }
        return true;
    }


}
