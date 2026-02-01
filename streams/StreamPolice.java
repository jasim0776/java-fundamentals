
import java.util.List;

public class StreamPolice{
    public List<Integer> processNumbers(List<Integer> input){

        List<Integer> result = input.stream()
        .filter(n -> n >0)
        .filter(n -> !(n%5==0 && n%10 !=0))
        .toList();

        return result;

    }
}