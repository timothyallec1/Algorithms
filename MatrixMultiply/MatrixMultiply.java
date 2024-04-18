import java.util.Vector;

public class MatrixMultiply{
    public static Vector<Vector<Double>> matrix_multiply(Vector<Vector<Double>> inputA, Vector<Vector<Double>> inputB){
        int aRows = inputA.size();
        int aCols = inputA.get(0).size();
        int bRows = inputB.size();
        int bCols = inputB.get(0).size();
        if (aCols != bRows) {
            throw new IllegalArgumentException("incompatible dimensions");
        }
        else{
            Vector<Vector<Double>> c = new Vector<Vector<Double>>();
            for (int i = 0; i < aRows; i++) {
                c.add(new Vector<Double>());
                for (int j = 0; j < bCols; j++) {
                    c.get(i).add(0.0);
                    for (int k = 0; k < aCols; k++) {
                        c.get(i).set(j, c.get(i).get(j) + inputA.get(i).get(k) * inputB.get(k).get(j));
                    }
                }
            }
            return c;
        }
    }

    public static void main(String[] args) {
        Vector<Vector<Double>> A = new Vector<Vector<Double>>();
        Vector<Vector<Double>> B = new Vector<Vector<Double>>();
        A.add(new Vector<Double>());
        A.add(new Vector<Double>());
        A.get(0).add(1.0);
        A.get(0).add(2.0);
        A.get(1).add(3.0);
        A.get(1).add(4.0);
        B.add(new Vector<Double>());
        B.add(new Vector<Double>());
        B.get(0).add(5.0);
        B.get(0).add(6.0);
        B.get(1).add(7.0);
        B.get(1).add(8.0);
        Vector<Vector<Double>> C = matrix_multiply(A, B);
        for (int i = 0; i < C.size(); i++) {
            for (int j = 0; j < C.get(0).size(); j++) {
                System.out.print(C.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}


