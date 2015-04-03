package patterns.structural;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvetrov on 23.03.15.
 */
public class Flyweight {
    public static void main(String[] args) {
        WordFlyweightFactory wordFlyweightFactory = new WordFlyweightFactory();
        wordFlyweightFactory.getWord("а").print();
        wordFlyweightFactory.getWord("b").print();
        wordFlyweightFactory.getWord("а").print();

    }
}

interface WordFlyweight {
    String getWord();
    void print();
}

class Word implements WordFlyweight {
    private String word;

    Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void print() {
        System.out.println(word);
    }
}

class WordFlyweightFactory {
    private List<WordFlyweight> pool;

    WordFlyweightFactory() {
        pool = new LinkedList<WordFlyweight>();
    }

    public WordFlyweight getWord(String wordString) {
        for(WordFlyweight wordFlyweight : pool) {
            if(wordFlyweight.getWord().equals(wordString)) {
                System.out.print("Word from pool: ");
                return wordFlyweight;
            }
        }
        WordFlyweight newWordFlyweight = new Word(wordString);
        pool.add(newWordFlyweight);
        System.out.print("New word: ");
        return newWordFlyweight;
    }
}