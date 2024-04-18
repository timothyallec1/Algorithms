// ICA 2 Binary Search: created by Timothy R. Allec on January 8, 2024.

public class BinarySearch {

    // this is a binary search method
    public static int function(int[] array, int n, int T){
        int leftSide = 0;
        int rightSide = n -1;

        while(leftSide < rightSide ){
            int midPoint = (leftSide+rightSide)/2;
            if(array[midPoint] < T){
                leftSide = midPoint+1;
            }
            else if(array[midPoint]> T){
                rightSide = midPoint-1;
            }
            else{
                return midPoint;
            }
        }
        return -1;
    }

    // main initiliazes an array and calls the function method to find the inputted value
    public static void main(String[] args){
        int val = 4; 
        int [] newArray = {1,2,3,4,5};
    
        int result = function(newArray, newArray.length, val);

        if (result != -1){
            System.out.println( + val +" was found at index " + result);
        } else {
            System.out.println(val + " was not found in the array");
        }
    }
}

