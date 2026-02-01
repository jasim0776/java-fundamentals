
import java.util.ArrayList;
import java.util.Collections;

public class Transformer {

    public static int[] transform(int[] arr) {

        ArrayList<Integer> unique = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int current = arr[i];

            if (unique.contains(current) == false) {
                unique.add(current);
            }
        }

        Collections.sort(unique, Collections.reverseOrder());

        for (int i = 2; i < unique.size(); i += 3) {
            int sum = unique.get(i - 1) + unique.get(i - 2);
            unique.set(i, sum);
        }

        for (int i = 0; i < unique.size() / 2; i++) {
            int temp = unique.get(i);
            unique.set(i, unique.get(unique.size() - 1 - i));
            unique.set(unique.size() - 1 - i, temp);
        }

        int[] result = new int[unique.size()];
        for (int i = 0; i < unique.size(); i++) {
            result[i] = unique.get(i);
        }

        return result;
    }
}
