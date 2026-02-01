
public class ArrayAdder {

    public static int[] concatArrays(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int[] sumArr = new int[length];
        for (int i = 0; i < length; i++) {
            if (i < arr1.length) {
                sumArr[i] = arr1[i];
            } else {
                sumArr[i] = arr2[i - arr1.length];
            }
        }
        return sumArr;

    }
}
