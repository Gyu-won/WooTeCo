package oncall.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calender {
    private static final int FIST_DAY = 1;
    private static final String SATURDAY = "토";
    private static final String SUNDAY = "일";
    private static final int INDEX_OFFSET = 1;
    private static final int DAY_OF_WEEK = 7;


    private static Integer month;
    private static final Map<Integer, String> weekdays = new HashMap<>();
    private static final List<Integer> holidays = new ArrayList<>();

    private static void createHolidayList() {
        Integer lastDay = Month.lastDay(month);
        for (int day = FIST_DAY; day <= lastDay; day++) {
            String weekday = weekdays.get(day);
            if (weekday.equals(SATURDAY) || weekday.equals(SUNDAY) || Month.isHoliday(month, day)) {
                holidays.add(day);
            }
        }
    }

    public static void create(Integer monthNumber, Weekday weekday) {
        month = monthNumber;
        Integer lastDay = Month.lastDay(month);
        for (int startDay = FIST_DAY; startDay <= lastDay; startDay++) {
            weekdays.put(startDay, weekday.find((startDay - INDEX_OFFSET) % DAY_OF_WEEK));
        }
        createHolidayList();
    }

    public static int lastDay() {
        return Month.lastDay(month);
    }

    public static boolean isHoliday(int day) {
        return holidays.contains(day);
    }

    public static int month() {
        return month;
    }

    public static String weekday(int day) {
        return weekdays.get(day);
    }
}
