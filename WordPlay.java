package wordPlay;

public class WordPlay {
    /*
    Create a new class called WordPlay.
Write a method isVowel that has one Char parameter named ch.
This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise.
     */
    public boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }else return false;
    }
    /*
    Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch.
    This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch.
    For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”.
     */
    public String replaceVowels(String phrase, char ch){
        for (int i = 0; i<phrase.length(); i++){
            if (isVowel(phrase.charAt(i))){
               phrase = phrase.replace(phrase.charAt(i), ch);
            }
            }
        return phrase;
    }
    /*
    Write a method emphasize with two parameters, a String named phrase and a character named ch.
    This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
     ‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
     ‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
     For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”.
     */
    public StringBuilder emphasize(StringBuilder phrase, char ch){
        for (int i = 0; i<phrase.length(); i++){
            if (phrase.charAt(i) == ch){
                if (i%2 == 0){
                    phrase.setCharAt(i, '*');
                }else phrase.setCharAt(i, '+');
            }
        }
        return phrase;
    }
}
