
import java.util.List;

public class StringToIntConverter {

    public List<Integer> convertStringListToIntList(List<String> str) {
        List<Integer> result = str.stream()
                .map(s -> Integer.parseInt(s))
                .toList();

        return result;

    }
}
