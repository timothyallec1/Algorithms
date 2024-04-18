// ICA 2 optimization of Binary Search: created by Timothy R. Allec on January 10, 2024.

public class BinarySearchOptimization {
// this is a terniary search method
   public static int function(int[] array, int n, int T) {
    int leftSide = 0;
    int rightSide = n - 1;
    while (leftSide <= rightSide) {
// this creates midpoints for the split 1/3 sections
        int mid1 = leftSide + (rightSide - leftSide) / 3;
        int mid2 = rightSide - (rightSide - leftSide) / 3;
        if (array[mid1] == T) {
            return mid1;
        }
        if (array[mid2] == T) {
            return mid2;
        }
        if (array[mid1] > T) {
            rightSide = mid1 - 1;
        } else if (array[mid2] < T) {
            leftSide = mid2 + 1;
        } else {
            leftSide = mid1 + 1;
            rightSide = mid2 - 1;
        }
    }
    return -1;
}

// this main initiliazes an array and calls the function method to find the inputted value
    public static void main(String[] args){
        int val = 4; 
        int [] newArray = {1,2,3,4,5,6,7,8,9,};
    
        int result = function(newArray, newArray.length, val);

        if (result != -1){
            System.out.println( + val +" was found at index " + result);
        } else {
            System.out.println(val + " was not found in the array");
        }
    }
    
}
