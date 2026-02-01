
public class Factorial {

    public int calculateFactorial(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

}
