package wordPlay;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WordLengths {
    /*
    Create a new class called WordLengths.
Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts.
This method should read in the words from resource and count the number of words of each length for all the words in resource,
storing these counts in the array counts.
        - For example, after this method executes, counts[k] should contain the number of words of length k.
        - If a word has a non-letter as the first or last character, it should not be counted as part of the word length.
        For example, the word And, would be considered of length 3 (the comma is not counted),
        the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is).
        Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma,
        but that is OK as there should not be many words in that category.
     */
    public void countWordLenghts(String resource, int counts[])
            throws FileNotFoundException {
        File file = new File(resource);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String word = sc.next();
            int finalLength = 0;
            int totalLength = word.length();
            if (Character.isLetter(word.charAt(0)) == false){
                finalLength = totalLength - 1;
            }
            if (Character.isLetter(word.charAt(totalLength-1)) == false){
                finalLength = totalLength - 1;
            }
            else finalLength = totalLength;
            counts[finalLength] += 1;
        }
        System.out.println(Arrays.toString(counts));
    }
    /*
    Write a void method testCountWordLengths that creates a FileResource so you can select a file,
    and creates a counts integer array of size 31.
    This method should call countWordLengths with a file and then print the number of words of each length.
     */
    public void testCountWordLengths(String resource) throws FileNotFoundException {
        File file = new File(resource);
        Scanner sc = new Scanner(file);
        int [] counts = new int[31];
        countWordLenghts(resource, counts);
    }
    /*
    Write a method indexOfMax that has one parameter named values that is an integer array.
    This method returns the index position of the largest element in values.
     */
    public static int indexOfMax(int values[])
    {
        int largest = values[0];

        for(int i = 0; i < values.length; i++)
        {
            if(values[i] > largest)
                largest = values[i];
        }

        return largest;
    }

}
