package kpekala.simplebrick.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetModel implements Serializable {
    private  String name;
    private int pieceCount;
    private String theme;
    private int year;
    private String imageLink;

    public SetModel(){}


    public SetModel(String name, int pieceCount, String theme, int year, String imageLink) {
        this.name = name;
        this.pieceCount = pieceCount;
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

    public int getPieceCount() {
        return pieceCount;
    }

    public String getTheme() {
        return theme;
    }

}