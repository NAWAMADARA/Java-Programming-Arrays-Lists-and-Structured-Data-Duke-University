package wordPlay;

public class CaeserBreaker {

public int[] countLetters(String message){
    String alphabets = "abcdefghijklmnopqrstuvwxyz";
    int arr[] = new int[26];
    char char1 = ' ';
    int index = 0;
    for (int k=0; k<message.length(); k++ ){
        char1 = Character.toLowerCase(message.charAt(k));
        index = alphabets.indexOf(char1);
        if (index != -1){
            arr[index] += 1;
        }
    }
    return arr;
}
public int maxIndex (int[] values){
    int maxDex = 0;
    for (int k = 0; k<values.length; k++){
        if (values[k] > values[maxDex]){
            maxDex = values[k];
        }
    }
    return maxDex;
}
}
