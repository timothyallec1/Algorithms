import java.util.Vector;

public class CountingSort{
    public static void counting_sort(Vector<Integer> data, Vector<Integer> sortedData, Integer max){
        Vector<Integer> count = new Vector<Integer>();
        for (int i = 0; i <= max; i++){
            count.add(0);
        }
        for (int i = 0; i < data.size(); i++){
            count.set(data.elementAt(i), count.elementAt(data.elementAt(i)) + 1);
        }
        for (int i = 1; i <= max; i++){
            count.set(i, count.elementAt(i) + count.elementAt(i - 1));
        }
        for (int i = data.size() - 1; i >= 0; i--){
            sortedData.add(0);
        }
        for (int i = data.size() - 1; i >= 0; i--){
            sortedData.set(count.elementAt(data.elementAt(i)) - 1, data.elementAt(i));
            count.set(data.elementAt(i), count.elementAt(data.elementAt(i)) - 1);
        }
    }
    public static void main (String[] args){
        Vector<Integer> myData = new Vector<Integer>();
        myData.add(11);
        myData.add(7);
        myData.add(12);
        myData.add(18);
        myData.add(21);
        myData.add(15);
        myData.add(14);
        myData.add(4);

        System.out.println("Original Data: " + myData);

        Integer max = myData.elementAt(0);
        for (int i = 1; i < myData.size(); i++){
            if (myData.elementAt(i) > max){
                max = myData.elementAt(i);
            }
        }
        Vector <Integer> mySortedData = new Vector<Integer>();
        counting_sort(myData, mySortedData, max);
        System.out.println("Sorted Data: " + mySortedData);

    }
}