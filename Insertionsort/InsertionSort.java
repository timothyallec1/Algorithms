public class InsertionSort {
    public static int[] insert(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3};
        int[] b = insert(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
