package hw7;

import java.util.Comparator;

public class AnagramFamilyComparator implements Comparator<AnagramFamily> {
    public int compare(AnagramFamily one, AnagramFamily two) {
        return one.getAnagramList().size() - two.getAnagramList().size();
    }
}
