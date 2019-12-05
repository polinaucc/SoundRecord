package Model;

import java.util.List;

public class MusicalCompositionWithoutWords extends MusicalComposition {
    private List<String> instruments;
    private int countOfPerformers;

    public MusicalCompositionWithoutWords(List<String> instruments, int countOfPerformers) {
        this.instruments = instruments;
        this.countOfPerformers = countOfPerformers;
    }
}
