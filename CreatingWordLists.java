package hw7;

import java.io.File;
import java.util.*;

public class CreatingWordLists {
    public static void main(String[] args) {
        Scanner scanned = scanFile();
        List<Word> wordList = createWordList(scanned);
        List<AnagramFamily> anagramFamilyList = createAnagramFamilyList(wordList);
        printInformation(anagramFamilyList);
    }
    
    public static Scanner scanFile() {
        //Scan File---------------------------------------------------
        Scanner fileScan = null;//initialize Scanner
        
        //import file
        try {
            fileScan = new Scanner(new File("words.txt"));
        } catch(Exception e) {//catch if file isn't found
            System.out.println("File not found");
        }
        return fileScan;
    }
    
    public static List<Word> createWordList(Scanner fileScan) {
        //Create word object for every word in file and put in a list
        List<Word> wordsList = new ArrayList<Word>();
        while(fileScan.hasNextLine()) {
            String temp = fileScan.nextLine();
            Word word = new Word(temp);
            wordsList.add(word);
        }
        Collections.sort(wordsList);
        return wordsList;
    }
    
    public static List<AnagramFamily> createAnagramFamilyList(List<Word> wordsList) {
        //Create List of Anagram Families
        List<AnagramFamily> anagramFamilyList = new ArrayList<AnagramFamily>();
        AnagramFamily anagramFamily = new AnagramFamily();
        anagramFamily.addWord(wordsList.get(0));
        anagramFamilyList.add(anagramFamily);
        for(int i = 1; i < wordsList.size(); i++) {
            if(wordsList.get(i).getCanonical().equals( wordsList.get(i - 1).getCanonical()) ) {
                anagramFamily.addWord(wordsList.get(i));
            } else {
                anagramFamily = new AnagramFamily();
                anagramFamily.addWord(wordsList.get(i));
                anagramFamilyList.add(anagramFamily);
            }
        }
        Collections.sort(anagramFamilyList, new AnagramFamilyComparator());
        return anagramFamilyList;
    }
    
    public static void printInformation(List<AnagramFamily> anagramFamilyList) {
        for(int i = anagramFamilyList.size() - 1; i > anagramFamilyList.size() - 11; i--) {
            System.out.print("Canonical Form: ");
            System.out.print(anagramFamilyList.get(i).getAnagramList().get(0).getCanonical());
            System.out.println(" (" + anagramFamilyList.get(i).getAnagramList().size() + " words)");
            for(int j = 0; j < anagramFamilyList.get(i).getAnagramList().size(); j++) {
                System.out.println(j + 1 + ". " + anagramFamilyList.get(i).getAnagramList().get(j));
            }
        }
    }
}
