package wordfreqs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordFrequencies {

private ArrayList<String> myWords;
private ArrayList<Integer> myFreqs;

public WordFrequencies(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
}

public void findUnique() throws FileNotFoundException {
    myWords.clear();
    myFreqs.clear();
    String resource = "";
    File file = new File(resource);
    Scanner sc = new Scanner(file);
    while (sc.hasNext()){
        String word = sc.next();
        word = word.toLowerCase();
        int index = myWords.indexOf(word);
        if (index == -1){
            myWords.add(word);
            myFreqs.add(1);
        }else {
            int freqs = myFreqs.indexOf(index);
            myFreqs.set(index, freqs+1);
        }
    }
}

public int indexOfMax(){
    Integer valueOfMax = Collections.max(myFreqs);
    Integer indexOfValueOfMax = myFreqs.indexOf(valueOfMax);
    return indexOfValueOfMax;
}

}
