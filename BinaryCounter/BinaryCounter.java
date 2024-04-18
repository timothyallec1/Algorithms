import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;

public class BinaryCounter{
    // this function increments a 4 bit by 1
public static int []function (int[] array){
    int i = 0;
    while (i < array.length && array[i] == 1){
        array[i] = 0;
        i = i +1;
    }
    if ( i < array.length -1){
            array[i] = 1;
        }
        return array;
    }
    
    // this main initiliazes an array and calls the function method to output the incremented 4 bit
public static void main(String[] args) {
    int [] arrayOne = {0,1,1,0};
    int [] arrayTwo = function(arrayOne);

    for (int i = 0; i < arrayTwo.length; i++){
    System.err.print(arrayTwo[i] + " ");
    }
}
}

