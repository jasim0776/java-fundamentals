public class PalindromeChecker {
    public static boolean isPalindrome(String str){

         if (str == null || str.isEmpty()) {
            return true;
        }
        
        String lowerCaedString = str.toLowerCase();
        StringBuilder message = new StringBuilder();
        for(int i=0; i<lowerCaedString.length(); i++){
            char ch = lowerCaedString.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                message.append(ch);
            }
        }
        StringBuilder reverseMessage = new StringBuilder(message).reverse();
        if(message.toString().equals(reverseMessage.toString())){
            return true;
        }else{
            return false; 
        }
    }
}