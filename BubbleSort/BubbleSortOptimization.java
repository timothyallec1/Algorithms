public class BubbleSortOptimization {
    public static int[] sortFunction(int[] a) {
        int n = a.length;
        // Optimization 1: Use a boolean flag to check if any swaps were made
        boolean swapped;
        // Optimization 2: Reduce the upper bound of the inner loop to avoid unnecessary comparisons
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    swapped = true;
                }
            }
            
            // Optimization 3: If no swaps were made, the array is already sorted
            if (!swapped) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 2, 6};
        int[] sortedData = sortFunction(data);

        System.out.println("Sorted Array:");
        for (int i : sortedData) {
            System.out.println(i);
        }
    }
}