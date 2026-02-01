
import java.util.ArrayList;

public class ArrayFilter {

    public static int[][] filterBySum(int[][] TwoDArr, int val) {
        ArrayList<int[]> validRows = new ArrayList<>();
        for (int i = 0; i < TwoDArr.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < TwoDArr[i].length; j++) {
                rowSum = TwoDArr[i][j] + rowSum;
            }
            if (rowSum > val) {
                validRows.add(TwoDArr[i]);
            }

        }
        int[][] result = new int[validRows.size()][];
        for (int i = 0; i < validRows.size(); i++) {
            result[i] = validRows.get(i);
        }
        return result;

    }
}
