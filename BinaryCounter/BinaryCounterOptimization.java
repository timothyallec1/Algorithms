import java.lang.InterruptedException;
import java.util.concurrent.TimeUnit;

public class BinaryCounterOptimization{

    public class TimerTest{
        public TimerTest(){
        }
    public void waittest(){
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        catch ( java.lang.InterruptedException e){
            System.out.println(e);
            
        }
    }
}
// this method increments an 8 bit
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
                       
    int [] arrayOne = {0,1,1,0,1,1,1,0};
    int [] arrayTwo = function(arrayOne);

    System.out.println("before timer \nresult:");
    for (int i = 0; i < arrayTwo.length; i++){
    System.err.print(arrayTwo[i] + " ");
    }
    
    // this creates a 2 second break in between  of the 8 bit using the time unit library
    TimerTest timer = new BinaryCounterOptimization().new TimerTest();
timer.waittest();
System.out.println();
    System.out.println("after timer \nresult:");
    for (int j = 0; j < arrayTwo.length; j++){
        System.err.print(arrayTwo[j] + " ");
        timer.waittest();
    }
}
}

