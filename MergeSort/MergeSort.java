import java.util.Vector;
public class MergeSort{
    public static void merge_sort(Vector<Integer> A, int p, int r){
        if(p < r){
            int q =(p+r)/2;
            merge_sort(A, p, q);
            merge_sort(A, q+1, r);
            merge(A, p, q, r);


        }
    }

        public static void merge(Vector<Integer> A, int p, int q, int r){
            int n1 = q-p+1;
            int n2 = r-q;
            Vector<Integer> L = new Vector<Integer>();
            Vector<Integer> R = new Vector<Integer>();
            for(int i = 0; i < n1; i++){
                L.add(A.get(p+i));
            }
            for(int j = 0; j < n2; j++){
                R.add(A.get(q+j+1));
            }
            L.add(Integer.MAX_VALUE);
            R.add(Integer.MAX_VALUE);
            int i = 0;
            int j = 0;
            for(int k = p; k <= r; k++){
                if(L.get(i) <= R.get(j)){
                    A.set(k, L.get(i));
                    i++;
                }
                else{
                    A.set(k, R.get(j));
                    j++;
                }
            }


        }
        public static void main(String[] args) {
            Vector<Integer> A = new Vector<Integer>();
            A.add(3);
            A.add(41);
            A.add(52);
            A.add(26);
            A.add(38);
            A.add(57);
            A.add(9);
            A.add(49);
            System.out.println("Before sorting: " + A);
            merge_sort(A, 0, A.size()-1);
            System.out.println("After sorting: " + A);
           
            }
        }

    

    
