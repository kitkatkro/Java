import java.io.IOException;

public class OperationsWithString {
    public static void main(String[] args) throws IOException{
        String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            String[][] stringMatrix = transformToMatrix(string);
            int result = transformToInteger(stringMatrix);
            System.out.println(result);
        } catch (MatrixDimensionException | NotNumberElementException e) {
            e.getMessage();
            e.printStackTrace();
            e.close();
        }

    }

    private static String[][] transformToMatrix(String s) throws MatrixDimensionException {
        String[] stringArray = s.split("\n");
        int rows = stringArray.length;
        int cols = 0;
        for (int i=0; i < rows; i++) {
            int temp = stringArray[i].split(" ").length;
            cols = (temp > cols) ? temp : cols;
        }
        if (rows != 4 || cols != 4) {
            throw new MatrixDimensionException();
        }
        String[][] stringMatrix = new String[stringArray.length][stringArray[0].split(" ").length];
        for (int i=0; i < stringArray.length; i++) {
            String[] temp = stringArray[i].split(" ");
            for (int j=0; j < temp.length; j++ ) {
                stringMatrix[i][j] = temp[j];
            }
        }
        return stringMatrix;
    }

    private static int transformToInteger(String[][] stringMatrix) throws NotNumberElementException {
        int sum = 0;
        for (int i=0; i < stringMatrix.length; i++) {
            for (int j=0; j < stringMatrix[0].length; j++) {
                try {
                    sum  += Integer.parseInt(stringMatrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new NotNumberElementException();
                }
            }
        }
        return sum/2;
    }
}
