import java.util.Random;

public class RandomizedSelect {
    // this method performs Randomized select
    public static int Function(int[] A, int p, int r, int i) {
        if (p == r) {
            return A[p];
        }
        int q = RandomizedPartition(A, p, r);
        int k = q - p + 1;
        if (i == k) {
            return A[q];
        } else if (i < k) {
            return Function(A, p, q, i);
        } else {
            return Function(A, q + 1, r, i - k);
        }
    }

    public static int RandomizedPartition(int[] A, int p, int r) {
        // implementation of the method
        Random myRandom = new Random(System.currentTimeMillis());
        int i = p + myRandom.nextInt(r - p + 1);
        swap(A, i, r);
        return Partition(A, p, r);
    }

    public static int Partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i = i + 1;
                if (i != j) {
                    swap(A, i, j);
                }
            }
            // if (A[j] <= x) {
            //     i = i + 1;
            //     swap(A, i, j);
            // }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] newArray = {7, 3, 6, 0, 8, 4};
        int nth = 4;
        int nthSmallest = Function(newArray, 0, newArray.length - 1, nth);
        System.out.println("The " + nth + "th smallest element is: " + nthSmallest);
    }
}
