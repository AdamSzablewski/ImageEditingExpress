package com.example.imageeditingexpress.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageSettings {

    private double contrast;
    private double hue;
    private double brightness;
    private double saturation;
    private int rotate;
}
