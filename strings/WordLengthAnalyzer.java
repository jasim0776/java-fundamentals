
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordLengthAnalyzer {

    public Map<Integer, Integer> analyzeWordLengths(List<String> words) {
        Map<Integer, Long> tempMap = words.stream().collect(Collectors.groupingBy(
                word -> word.length(), Collectors.counting()
        ));

        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Long> entry : tempMap.entrySet()) {
            result.put(entry.getKey(), entry.getValue().intValue());
        }

        return result;
    }
}
