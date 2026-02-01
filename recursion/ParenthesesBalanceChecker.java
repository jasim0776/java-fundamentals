
public class ParenthesesBalanceChecker {

    public boolean isBalanced(String str) {

        // null input
        if (str == null) {
            return false;
        }

        // start recursion
        return checkBalance(str, 0, 0);
    }

    private boolean checkBalance(String str, int index, int balance) {

        // if more closing than opening
        if (balance < 0) {
            return false;
        }

        // reached end of string
        if (index == str.length()) {
            return balance == 0;
        }

        char ch = str.charAt(index);

        // opening parenthesis
        if (ch == '(') {
            return checkBalance(str, index + 1, balance + 1);
        }

        // closing parenthesis
        if (ch == ')') {
            return checkBalance(str, index + 1, balance - 1);
        }

        // ignore other characters
        return checkBalance(str, index + 1, balance);
    }
}
