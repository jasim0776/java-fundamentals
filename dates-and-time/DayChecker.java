import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayChecker{
    public static String checkDayType(LocalDate date){
        DayOfWeek dayName = date.getDayOfWeek();

        String s = dayName.toString(); 

        switch(s){
            case "SATURDAY":
                return "Weekend";
            case "SUNDAY":
                return "Weekend";
        
            case "WEDNESDAY" : 
            return "Hump Day!";
        
            
            default :
            return "Weekday";
        }

    }
}