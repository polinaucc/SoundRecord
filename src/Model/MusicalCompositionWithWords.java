package Model;

public class MusicalCompositionWithWords extends MusicalComposition {
    String language;
    private int countOfSingers;
    String textAuthor;


    public MusicalCompositionWithWords(String name, String author, String style, float duration, String language) {
        super(name, author, style, duration);
        this.language = language;
    }
}
