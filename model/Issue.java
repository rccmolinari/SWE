package model;

public class Issue {
    private String title;
    private String description;
    private String urlImage;
    private String status;

    public Issue(String title, String description, String urlImage, String status) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrlImage() {
        return urlImage;
    }
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
