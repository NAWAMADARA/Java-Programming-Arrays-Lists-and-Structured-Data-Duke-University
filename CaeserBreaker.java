package wordPlay;

public class CaeserBreaker {
    /*
    Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters, maxIndex, and decrypt.
    Recall that the decrypt method creates a CaesarCipher object in order to use the encrypt method you wrote for the last lesson.
    Make sure that your CaesarCipher class is in the same folder as CaesarBreaker!
     */
    public int[] countLetters(String message) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int arr[] = new int[26];
        char char1 = ' ';
        int index = 0;
        for (int k = 0; k < message.length(); k++) {
            char1 = Character.toLowerCase(message.charAt(k));
            index = alphabets.indexOf(char1);
            if (index != -1) {
                arr[index] += 1;
            }
        }
        return arr;
    }

    public int maxIndex(int[] values) {
        int maxDex = 0;
        for (int k = 0; k < values.length; k++) {
            if (values[k] > values[maxDex]) {
                maxDex = values[k];
            }
        }
        return maxDex;
    }

    public String decrypt(String encrypted, int key) {
        CaesarCipher cc = new CaesarCipher();
        int freqs[] = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }

    /*
   public void testDecrypt(){
       CaesarCipher cc = new CaesarCipher();
       String messageToBeEncrypted = ("Hi My NAME is SHAHZAD");
   String message = cc.modifiedEncrypt(messageToBeEncrypted, 12);
       System.out.println("encrypted String: " + message);
       System.out.println("Decrypted message: " + decrypt(message, 12));
   }

   Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start.
   This method should return a new String that is every other character from message starting with the start position.
   For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”.
     */
    public String halfOfString(String message, int start) {
        StringBuilder string = new StringBuilder();
        for (int k = start; k<message.length(); k+=2){
            string.append(message.charAt(k));
        }
        return string.toString();
    }
    /*
    Write the method getKey in the CaesarBreaker class that has one parameter, a String s.
    This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency,
    which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
     */
    public int getKey (String s){
        int freqs [] = countLetters(s);
        int key = maxIndex(freqs);
        int dkey = key-4;
        if (dkey < 0) dkey = 26 - (4 - key);
        return dkey;
    }
    /*
    Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter,
    a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed in the previous lesson.
    This method attempts to determine the two keys used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys.
     */
    public String decryptTwoKeys(String encrypted){
        String everyOtherString1 = halfOfString(encrypted, 0);
        String everyOtherString2 = halfOfString(encrypted, 1);
        int key1 = getKey(everyOtherString1);
        int key2 = getKey(everyOtherString2);
        System.out.println("The two keys found are: " + key1 + "and " + key2);
        return "";
    }
}


