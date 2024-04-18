/*Create a new version of the given algorithm that handles String input 
of length 32 characters. Implement this
in Java
 * After sorting, the strings are ordered based on their lengths, 
 * with shorter strings appearing before longer ones. 
 * If two strings have the same length, their order remains the same
 *  as in the original array.
 */

import java.util.ArrayList;
import java.util.List;

public class StringBucketSort {
    public static void stringBucketSort(String[] A) {
        int n = A.length;
        int maxStringLength = getMaxStringLength(A); // Find the maximum string length in A
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < maxStringLength; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute strings into buckets based on their lengths
        for (int i = 0; i < n; i++) {
            String str = A[i];
            int strLength = str.length();
            buckets.get(strLength - 1).add(str);
        }

        // Concatenate the strings from the buckets to form the sorted array of strings
        int index = 0;
        for (int i = 0; i < maxStringLength; i++) {
            List<String> bucket = buckets.get(i);
            for (String str : bucket) {
                A[index++] = str;
            }
        }
    }

    public static int getMaxStringLength(String[] A) {
        int max = 0;
        for (String str : A) {
            if (str.length() > max) {
                max = str.length();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] A = {"abcdefg", "zxy", "mnopqrstuvwxyz", "pqrstu", "ijk"};
        stringBucketSort(A);
        for (String str : A) {
            System.out.println(str);
        }
    }
}
