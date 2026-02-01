
import java.util.List;

public class UsernameProcessor {

    public String findFirstUsername(List<String> str) {
        String result = str.stream()
                .findFirst().orElse("Anonymous");

        return result;
    }
}
