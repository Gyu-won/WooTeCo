package oncall.view;

import java.util.List;
import oncall.domain.entity.Calender;
import oncall.domain.entity.Month;
import oncall.domain.entity.TimeTable;
import oncall.view.message.Result;

public class OutputView {
    private static final int FIRST_DAY = 1;
    private static final String SATURDAY = "토";
    private static final String SUNDAY = "일";
    private static final String HOLIDAY = "(휴일)";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printTimeTable() {
        int month = Calender.month();
        List<String> timeTable = TimeTable.timeTable();
        for (int day = FIRST_DAY; day <= Month.lastDay(month); day++) {
            String weekday = createWeekdayToString(month, day);
            System.out.printf(Result.DAY_WORKER.getMessage(), month, day, weekday, timeTable.get(day));
            if (day != Month.lastDay(month)) {
                System.out.println();
            }
        }
    }

    private static String createWeekdayToString(int month, int day) {
        String weekday = Calender.weekday(day);
        if (Month.isHoliday(month, day) && !weekday.equals(SATURDAY) && !weekday.equals(SUNDAY)) {
            return weekday + HOLIDAY;
        }
        return weekday;
    }
}