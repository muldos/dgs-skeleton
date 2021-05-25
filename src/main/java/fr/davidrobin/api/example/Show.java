package fr.davidrobin.api.example;

public class Show {
    private String title;
    private Integer releaseYear ;

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