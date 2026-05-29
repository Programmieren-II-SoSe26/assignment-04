package GenericMediaLibrary;

public class Movie implements Media {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}