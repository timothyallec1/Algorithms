public class BucketSort {
    public static void bucketSort(int[] A) {
        int n = A.length;
        int max = getMax(A); // Find the maximum value in A
        int[] B = new int[max + 1]; // B needs to accommodate values from 0 to max
        for (int i = 0; i < n; i++) {
            B[A[i]]++;
        }
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i]; j++) {
                A[index++] = i;
            }
        }
    }

    public static int getMax(int[] A) {
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] A = {56, 23, 90, 51, 29, 34, 55};
        bucketSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
