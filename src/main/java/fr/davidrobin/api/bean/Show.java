package fr.davidrobin.api.bean;

public class Show {
    private String title;
    private String platform;
    private Integer releaseYear;

    public Show(String title, String platform, Integer releaseYear) {
        super();
        this.title = title;
        this.platform = platform;
        this.releaseYear = releaseYear;
    }

    public Show() {
        super();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
}