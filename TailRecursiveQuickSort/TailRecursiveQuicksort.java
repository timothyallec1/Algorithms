public class TailRecursiveQuicksort {
    public static void tailRecursiveQuickSort(int[] A, int p, int r) {
        while (p < r) {
            int[] q = partition(A, p, r);
            tailRecursiveQuickSort(A, p, q[0] - 1);
            p = q[1] + 1;
        }
    }

    public static int[] partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return new int[]{i + 1, i + 1}; // returning both indices
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 4, 2, 1};
        tailRecursiveQuickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

