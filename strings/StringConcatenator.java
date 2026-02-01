package sprint;

public class  StringConcatenator{
    public static String concatenate(String...str){
        StringBuilder result = new StringBuilder(); 
        for(String words : str){
            result = result.append(words);
        }
        return result.toString();
    }
}