package oncall.view;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Month;
import oncall.domain.entity.TimeTable;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printTimeTable() {
        int month = Calender.month();
        List<String> timeTable = TimeTable.timeTable();
        for (int day = 1; day <= Month.lastDay(month); day++) {
            String weekday = createWeekdayToString(month, day);
            System.out.printf("%d월 %d일 %s %s", month, day, weekday, timeTable.get(day));
            if (day != Month.lastDay(month)) {
                System.out.println();
            }
        }
    }

    private static String createWeekdayToString(int month, int day) {
        String weekday = Calender.weekday(day);
        if (Month.isHoliday(month, day) && !weekday.equals("토") && !weekday.equals("일")) {
            return weekday + "(휴일)";
        }
        return weekday;
    }
}