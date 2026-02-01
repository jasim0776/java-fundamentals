
public class OccurrenceCounter {

    public int countOccurrences(int[] arr, int element, int index) {

        // -------- base cases --------
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (index < 0 || index >= arr.length) {
            return 0;
        }

        // -------- check current index --------
        int count = 0;

        if (arr[index] == element) {
            count = 1;
        }

        // -------- recursive call --------
        return count + countOccurrences(arr, element, index + 1);
    }
}
