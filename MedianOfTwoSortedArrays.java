package wordPlay;

public class MedianOfTwoSortedArrays {
    public double medianOfTwoSortedArrays (int arr1 []){
        for (int i = 0; i<arr1.length-1; i++){
            if (arr1[i] > arr1[i+1]){
                arr1[i+1] = arr1[i];
            }
        }
        return 0.0;
    }
}
