
public class AnagramChecker {

    public static boolean areAnagrams(String input1, String input2) {
        String firstInput = input1.toLowerCase();
        String secondInput = input2.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < secondInput.length(); i++) {
            char ch = secondInput.charAt(i);
            if (Character.isLetter(ch)) {
                sb.append(ch);
            }
        }

        for (int i = 0; i < firstInput.length(); i++) {
            char ch = firstInput.charAt(i);
            if (Character.isLetter(ch)) {
                int index = sb.indexOf(String.valueOf(ch));
                if (index == -1) {
                    return false;
                }
                sb.deleteCharAt(index);
            }
        }
        if (sb.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
