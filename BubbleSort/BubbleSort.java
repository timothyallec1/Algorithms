
public class BubbleSort {
    public static int[] sortFunction(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 2, 6};
        int[] sortedData = sortFunction(data);

        System.out.println("Sorted Array:");
        for (int i = 0; i < sortedData.length; i++) {
            System.out.println(sortedData[i]);
        }
    }
}
