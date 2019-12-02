package Model;

public class AuthorSong extends MusicalCompositionWithWords {
    public int rankingPlace;

    public AuthorSong(String name, String author, String style, float duration, String language, int rankingPlace) {
        super(name, author, style, duration, language);
        this.rankingPlace = rankingPlace;
    }
}
