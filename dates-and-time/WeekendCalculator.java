import java.time.DayOfWeek;
import java.time.LocalDate;



public class WeekendCalculator {
    public static long countWeekendDays(LocalDate start, LocalDate end){
        long weekendCound = 0 ; 
        if(start.isAfter(end)){
            return 0;
        }

        LocalDate current = start;

        while(!current.isAfter(end)){
            DayOfWeek day = current.getDayOfWeek();
            if(day== DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
                weekendCound += 1;
            
            } 

            current = current.plusDays(1);
        }
        return weekendCound; 

    }
}
