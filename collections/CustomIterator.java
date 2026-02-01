
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomIterator implements Iterator<Integer> {

    private List<Integer> numbers;

    private int index;

    public CustomIterator(List<Integer> numbers) {
        this.numbers = numbers;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < numbers.size();
    }

    @Override
    public Integer next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Integer value = numbers.get(index);

        index++;

        return value;
    }
}
