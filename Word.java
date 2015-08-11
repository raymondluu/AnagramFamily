package hw7;

import java.util.ArrayList;
import java.util.Collections;

public class Word implements Comparable<Word>{
    private String plainForm;
    private String canonicalForm = "";
    
    //constructor
    public Word(String plainForm) {
        this.plainForm = plainForm;
        
        //computes canonicalForm
        ArrayList<Character> character = new ArrayList<Character>();
        for(int i = 0; i < plainForm.length(); i++) {
            character.add(plainForm.charAt(i));
        }
        Collections.sort(character);
        for(Character ch : character) {
            canonicalForm = canonicalForm + ch;
        }
    }
    
    //get Canonical form
    public String getCanonical() {
        return canonicalForm;
    }
    
    public String toString() {
        return plainForm;
    }
    
    public int compareTo(Word other) {
        return getCanonical().compareTo(other.getCanonical());
    }
}
