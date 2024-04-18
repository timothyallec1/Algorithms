import java.util.Vector;

public class LongestCommonSubsequence {
    public Vector<String> LCSLength(Vector<String> X, Vector<String> Y) {
        int m = X.size();
        int n = Y.size();
        int[][] b = new int[m][n];
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.get(i - 1).equals(Y.get(j - 1))) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i - 1][j - 1] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i - 1][j - 1] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i - 1][j - 1] = 3;
                }
            }
        }
        Vector<String> result = new Vector<>();
        PrintLCS(b, X, m, n, result);
        return result;
    }

    public void PrintLCS(int[][] b, Vector<String> X, int i, int j, Vector<String> result) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i - 1][j - 1] == 1) {
            PrintLCS(b, X, i - 1, j - 1, result);
            result.add(X.get(i - 1)); // Add the common element to the result vector
        } else if (b[i - 1][j - 1] == 2) {
            PrintLCS(b, X, i - 1, j, result);
        } else {
            PrintLCS(b, X, i, j - 1, result);
        }
    }

    public static void main(String[] args) {
        // Example vectors
        Vector<String> vectorX = new Vector<>();
        vectorX.add("A");
        vectorX.add("B");
        vectorX.add("C");
        vectorX.add("B");
        vectorX.add("D");
        vectorX.add("A");
        vectorX.add("B");

        Vector<String> vectorY = new Vector<>();
        vectorY.add("B");
        vectorY.add("D");
        vectorY.add("C");
        vectorY.add("A");
        vectorY.add("B");
        vectorY.add("A");

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        Vector<String> result = lcs.LCSLength(vectorX, vectorY);

        // Print the original vectors
        System.out.println("Vector 1: " + vectorX);
        System.out.println("Vector 2: " + vectorY);

        // Print the Longest Common Subsequence
        System.out.println("Longest Common Subsequence:");
        for (String element : result) {
            System.out.print(element + " ");
        }
    }
}
