import java.util.List;

public class EmailDomainExtractor{
    public List<String> extractDomains(List<String> emailList){
        List<String> result = emailList.stream()
        .filter(email -> email.indexOf("@")>0 && 
        email.indexOf("@") == email.lastIndexOf("@") && 
        email.indexOf("@") < email.length()-1)
        .map(email -> email.substring(email.indexOf("@") + 1).toLowerCase())
        .distinct()
        .toList();
        return result;
    }
}