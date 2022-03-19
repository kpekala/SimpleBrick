package kpekala.simplebrick.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetModel implements Serializable {
    private  String name;
    private int pieces;
    private String theme;
    private int year;
    private Image image;

    public SetModel(){}


    public SetModel(String name, int pieces, String theme, int year, Image image) {
        this.name = name;
        this.pieces = pieces;
        this.theme = theme;
        this.year = year;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }
    public String getName() {
        return name;
    }

    public int getPieces() {
        return pieces;
    }

    public String getTheme() {
        return theme;
    }

}