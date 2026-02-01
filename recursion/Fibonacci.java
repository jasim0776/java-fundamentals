
public class Fibonacci {

    public int calculateFibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

}
