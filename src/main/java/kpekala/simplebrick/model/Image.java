package kpekala.simplebrick.model;

public class Image {
    private String imageURL;
    private String thumbnailURL;

    public Image(String imageURL, String thumbnailURL) {
        this.imageURL = imageURL;
        this.thumbnailURL = thumbnailURL;
    }

    public Image() {
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
