public class SquareMatrixMultiply{
    public int[][] multiply(int[][] A, int[][] B){
        int n = A.length;
        int[][] C = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                C[i][j] = 0;
                for(int k=0; k<n; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        SquareMatrixMultiply smm = new SquareMatrixMultiply();
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = smm.multiply(A, B);
        for(int i=0; i<C.length; i++){
            for(int j=0; j<C.length; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}