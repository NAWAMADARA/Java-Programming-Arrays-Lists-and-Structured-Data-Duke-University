package wordPlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordFrequencies {

/*
Create two private variables. One is called myWords and should be an ArrayList of type String to store unique words from a file,
and one is called myFreqs and should be an ArrayList of type Integer.
The kth position in myFreqs should represent the number of times the kth word in myWords occurs in the file.
 */

private ArrayList<String> myWords;
private ArrayList<Integer> myFreqs;

/*
Write a constructor WordFrequencies, and initialize the private variables.
 */

public WordFrequencies(){
    myWords = new ArrayList<String>();
    myFreqs = new ArrayList<Integer>();
}

/*
Write a void method findUnique that has no parameters. This method should first clear both myWords and myFreqs,
using the .clear() method. Then it selects a file and then iterates over every word in the file,
putting the unique words found into myWords. For each word in the kth position of myWords,
it puts the count of how many times that word occurs from the selected file into the kth position of myFreqs, as was demonstrated in the lesson.
 */

public void findUnique(String resource) throws FileNotFoundException {
    myWords.clear();
    myFreqs.clear();
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

/*
Write the method findIndexOfMax that has no parameters.
This method returns an int that is the index location of the largest value in myFreqs.
If there is a tie, then return the first such value.
 */

public int findIndexOfMax(){
    Integer valueOfMax = Collections.max(myFreqs);
    Integer indexOfValueOfMax = myFreqs.indexOf(valueOfMax);
    return indexOfValueOfMax;
}

/*
Write a void tester method that has no parameters. This method should call findUnique.
Then print out the number of unique words, and for each unique word, print the frequency of each word and the word,
as was demonstrated in the lesson.
 */

    public void tester() throws FileNotFoundException {
        findUnique("C:/Users/Lenovo/OneDrive/Desktop/notetest.txt/");
    }

}
