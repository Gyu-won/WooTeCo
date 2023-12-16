package oncall.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calender {
    private static Integer month;
    private static final Map<Integer, String> weekdays = new HashMap<>();
    private static final List<Integer> holidays = new ArrayList<>();

    private static void createHolidayList() {
        Integer lastDay = Month.lastDay(month);
        for (int day = 1; day <= lastDay; day++) {
            String weekday = weekdays.get(day);
            if (weekday.equals("토") || weekday.equals("일") || Month.isHoliday(month, day)) {
                holidays.add(day);
            }
        }
    }

    public static void create(Integer monthNumber, Weekday weekday) {
        month = monthNumber;
        Integer lastDay = Month.lastDay(month);
        for (int startDay = 0; startDay < lastDay; startDay++) {
            weekdays.put(startDay + 1, weekday.find(startDay % 7));
        }
        createHolidayList();
    }

    public static int lastDay() {
        return Month.lastDay(month);
    }
}
