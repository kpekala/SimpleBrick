package kpekala.simplebrick.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetModel implements Serializable {
    private  String name;
    private int pieces;
    private String theme;
    private int year;
    private String imageLink;

    public SetModel(){}


    public SetModel(String name, int pieces, String theme, int year, String imageLink) {
        this.name = name;
        this.pieces = pieces;
        this.theme = theme;
        this.year = year;
        this.imageLink = imageLink;
    }

    public String getImageLink() {
        return imageLink;
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