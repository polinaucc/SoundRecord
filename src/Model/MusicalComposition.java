package Model;

public class MusicalComposition {

    private String name, author, style;
    private float duration;

    public MusicalComposition(){}

    public MusicalComposition(String name, String author, String style, float duration) {
        this.name = name;
        this.author = author;
        this.style = style;
        if (duration<0) throw new IllegalArgumentException("The duration must be more than 0");
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String country) {
        this.author = country;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
