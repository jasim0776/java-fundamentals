
import java.util.List;
import java.util.Optional;

public class NumberProcessor {

    public Optional<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n >= 10)
                .reduce((a, b) -> a * b);
    }
}
