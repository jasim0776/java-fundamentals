package sprint;

public class RecursivePalindrome {

    public boolean isPalindrome(String str) {

        // null check
        if (str == null) {
            return false;
        }

        // start recursion
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    // renamed helper method
    private boolean isPalindromeHelper(String str, int start, int end) {

        // base case: nothing left to check
        if (start >= end) {
            return true;
        }

        char left = str.charAt(start);
        char right = str.charAt(end);

        // skip non-alphanumeric from left
        if (!Character.isLetterOrDigit(left)) {
            return isPalindromeHelper(str, start + 1, end);
        }

        // skip non-alphanumeric from right
        if (!Character.isLetterOrDigit(right)) {
            return isPalindromeHelper(str, start, end - 1);
        }

        // ignore case
        left = Character.toLowerCase(left);
        right = Character.toLowerCase(right);

        // compare characters
        if (left != right) {
            return false;
        }

        // move inward
        return isPalindromeHelper(str, start + 1, end - 1);
    }
}
