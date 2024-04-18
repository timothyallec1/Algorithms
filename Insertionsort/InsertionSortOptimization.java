// this optimization utilizes a LinkedList instead of an Array for InsertionSort

import java.util.LinkedList;

public class InsertionSortOptimization{
    public static void insertion_sort(LinkedList<Integer> A){
        for(int j = 1; j < A.size(); j++){
            int key = A.get(j);
            int i = j-1;
            while(i >= 0 && A.get(i) > key){
                A.set(i+1, A.get(i));
                i = i-1;
            }
            A.set(i+1, key);
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> A = new LinkedList<Integer>();
        A.add(5);
        A.add(2);
        A.add(4);
        A.add(6);
        A.add(1);
        A.add(3);
        insertion_sort(A);
        for(int i = 0; i < A.size(); i++){
            System.out.println(A.get(i));
        }
    }
}
