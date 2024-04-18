import java.util.Vector;

public class optimization {

    public static void print_LCS(Vector<Vector<Integer>> cInput,String xInput, String yInput, int i, int j ){
        if(i==0 || j == 0){
            System.out.println();
            return;
        }

        String direction ="";

        int cCurrent = cInput.get(i).get(j);
        int dValue = cInput.get(i-1).get(j-1);
        int uValue = cInput.get(i-1).get(j);
        int lValue = cInput.get(i).get(j-1);

        Character myXinputChar = xInput.charAt(i-1);
        Character myYinputChar = yInput.charAt(j-1);

        // default: the element to the left
        direction = "l";

        if(myXinputChar.equals(myYinputChar)){
                direction = "d";
            }
        else if(uValue >= lValue){
            direction = "u";
        }
            System.out.println("The direction is: " + direction);
            if(direction.equals("d")){
                print_LCS(cInput, xInput, yInput, i-1, j-1);
                System.out.print(myXinputChar);
            }
            else if(direction.equals("u")){
                print_LCS(cInput, xInput, yInput, i-1, j);
            }
            else if(direction.equals("l")){
                print_LCS(cInput, xInput, yInput, i, j-1);
            }
        }

        public static void main(String[] args) {
            
            String xInput = "ABCBDAB";
            String yInput = "BDCABA";

            Vector<Vector<Integer>> cTable = new Vector<Vector<Integer>>();

            // initiliaze the tables
            for(int i = 0; i <= xInput.length(); i++){
                Vector<Integer> cRow = new Vector<Integer>();
                for(int j = 0; j <= yInput.length(); j++){
                    cRow.add(0);
                }
                cTable.add(cRow);
            }

            // consider only C table
            for(int i = 1; i <= xInput.length(); i++){
                for(int j = 1; j <= yInput.length(); j++){
                    Character myXinputChar = xInput.charAt(i-1);
                    Character myYinputChar = yInput.charAt(j-1);
                    if(myXinputChar.equals(myYinputChar)){
                        cTable.get(i).set(j, cTable.get(i-1).get(j-1) + 1);
                    }
                    else if(cTable.get(i-1).get(j) >= cTable.get(i).get(j-1)){
                        cTable.get(i).set(j, cTable.get(i-1).get(j));
                    }
                    else{
                        cTable.get(i).set(j, cTable.get(i).get(j-1));
                    }
                }
            }

            print_LCS(cTable, xInput, yInput, 0, 0);
        }

        

       
    }

    

