package Controller;

import Model.Album;
import Model.MusicalComposition;
import Model.MusicalCompositionWithWords;
import Model.Player;

public class Controller {
    public void process() {
        MusicalComposition mc1 = new MusicalComposition("Song1", "Singer1", "style2", 3.25f);
        MusicalComposition mc2 = new MusicalCompositionWithWords("Song2", "Singer2", "style1", 3f, "Ukrainian");
        MusicalComposition mc3 = new MusicalCompositionWithWords("Song3", "Singer3", "style2", 2.45f, "Russian");

        Album album = new Album(5);
        album.addComposition(mc1, mc2, mc3);

        Player player = new Player(album);
        player.sortByStyle();
        System.out.println(player.getTrackList());
    }
}
