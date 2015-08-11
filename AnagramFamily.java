package hw7;

import java.util.*;

public class AnagramFamily {
    private List<Word> anagrams = new ArrayList<Word>();
    
    public AnagramFamily() {
    }
    
    public AnagramFamily(List<Word> words) {
        for(Word w : words) {
            anagrams.add(w);
        }
    }
    
    public void addWord(Word w) {
        anagrams.add(w);
    }
    
    public List<Word> getAnagramList() {
        return anagrams;
    }
}
