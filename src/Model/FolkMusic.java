package Model;

public class FolkMusic extends MusicalCompositionWithWords {
    public static final String author = "people";

    public FolkMusic(String name, String author, String style, float duration, String language, String nationality) {
        super(name, author, style, duration, language);
        this.nationality = nationality;
    }

    String nationality;
}
