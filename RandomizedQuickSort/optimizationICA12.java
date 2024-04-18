import java.util.concurrent.ThreadLocalRandom;

public class optimizationICA12 {
    public static void randomizedQuicksort(int[] A, int p, int r) {
        if (p < r) {
            int[] q = randomizedPartition(A, p, r);
            randomizedQuicksort(A, p, q[0] - 1);
            randomizedQuicksort(A, q[1] + 1, r);
        }
    }

    public static int[] randomizedPartition(int[] A, int p, int r) {
        int i = ThreadLocalRandom.current().nextInt(p, r + 1);
        swap(A, i, r);
        return partition(A, p, r);
    }

    public static int[] partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        int j = p - 1;
        for (int k = p; k <= r - 1; k++) {
            if (A[k] < x) {
                i++;
                j++;
                swap(A, i, j);
            } else if (A[k] == x) {
                j++;
                swap(A, k, j);
            }
        }
        swap(A, i + 1, r);
        return new int[]{i, j};
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 10, 2, 7, 5, 4, 6, 9, 8};
        randomizedQuicksort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
