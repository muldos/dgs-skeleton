package fr.davidrobin.api.bean;

public class Show {
    private String title;
    private Integer releaseYear;

    public Show(String title, Integer releaseYear) {
        super();
        this.title = title;
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

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
}