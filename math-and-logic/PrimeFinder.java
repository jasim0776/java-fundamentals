
import java.util.ArrayList;
import java.util.List;

public class PrimeFinder{
    public static List<Integer> findPrimesUpTo(int limit){

        List<Integer> primeNumbers = new ArrayList<>();
        

        for(int i=2; i<=limit ; i++){
            boolean isprime = true;
            for(int j=2; j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isprime = false;
                    break;
                }
            }
            if(isprime){
                primeNumbers.add(i);
            }

        }
        return primeNumbers;

    }
}