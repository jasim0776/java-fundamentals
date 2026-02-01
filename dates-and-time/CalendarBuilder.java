import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarBuilder {

    public static String buildCalendar(String month, int year) {

        Month monthEnum = Month.valueOf(month.toUpperCase());
        int daysInMonth = monthEnum.length(java.time.Year.isLeap(year));

        LocalDate firstDay = LocalDate.of(year, monthEnum, 1);
        DayOfWeek startDay = firstDay.getDayOfWeek();

        int startIndex = startDay.getValue() - 1;

        StringBuilder sb = new StringBuilder();

        // header
        sb.append(monthEnum).append(" ").append(year).append("\n");
        sb.append("Mon Tue Wed Thu Fri Sat Sun\n");

        // empty days
        for (int i = 0; i < startIndex; i++) {
            sb.append("    ");
        }

        // days
        for (int day = 1; day <= daysInMonth; day++) {

            if (day < 10) {
                sb.append("  ").append(day);
            } else {
                sb.append(" ").append(day);
            }

            if ((startIndex + day) % 7 == 0) {
                sb.append("\n");
            } else if (day != daysInMonth) {
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}
