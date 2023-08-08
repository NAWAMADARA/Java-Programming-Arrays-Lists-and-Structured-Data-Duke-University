package wordPlay;

import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Locale;

public class CaesarCipher {
    /*
    Write the method encrypt that has two parameters, a String named input and an int named key.
    This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos.
    Assume that all the alphabetic characters are uppercase letters. For example, the call

    encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
    should return the string
        “CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”
     */

    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i<encrypted.length(); i++ ){
            char currenChar = encrypted.charAt(i);
            int index = alphabet.indexOf(currenChar);
            if(index != -1){
                char newChar = shiftedAlphabet.charAt(index);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    /*
   Modify the encrypt method to be able to handle both uppercase and lowercase letters.
   For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”.
    */
    public String modifiedEncrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i<encrypted.length(); i++ ){
            char currentChar = encrypted.charAt(i);

            int index = alphabet.indexOf(Character.toUpperCase(currentChar));
            if(index != -1){
                char newChar = shiftedAlphabet.charAt(index);
                if(Character.isUpperCase(currentChar)){
                    encrypted.setCharAt(i, newChar);
                }else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }

            }
        }
        return encrypted.toString();
    }

    /*
    Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2.
    This method returns a String that has been encrypted using the following algorithm.
    Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character,
    and key2 is used to encrypt every other character, starting with the second character.
    For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”.
    Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc.
     */
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i<encrypted.length(); i+=2 ){
            char currentChar = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(currentChar));
            if(index != -1){
                char newChar = shiftedAlphabet.charAt(index);
                if(Character.isUpperCase(currentChar)){
                    encrypted.setCharAt(i, newChar);
                }else{
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                }
            }
        }for (int k = 1; k<encrypted.length(); k+=2 ){
            char currentChar = encrypted.charAt(k);
            int index = alphabet.indexOf(Character.toUpperCase(currentChar));
            if(index != -1){
                char newChar = shiftedAlphabet2.charAt(index);
                if(Character.isUpperCase(currentChar)){
                    encrypted.setCharAt(k, newChar);
                }else{
                    encrypted.setCharAt(k, Character.toLowerCase(newChar));
                }

            }
        }
        return encrypted.toString();
    }

}
