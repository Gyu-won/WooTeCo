package oncall.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calender {
    private final Integer month;
    private final Map<Integer, String> weekdays = new HashMap<>();
    private final List<Integer> holidays = new ArrayList<>();

    public Calender(Integer month, Weekday weekday) {
        this.month = month;
        create(month, weekday);
        createHolidayList();
    }

    private void createHolidayList() {
        Integer lastDay = Month.lastDay(month);
        for (int day = 1; day <= lastDay; day++) {
            String weekday = weekdays.get(day);
            if (weekday.equals("토") || weekday.equals("일") || Month.isHoliday(month, day)) {
                holidays.add(day);
            }
        }
    }

    private void create(Integer month, Weekday weekday) {
        Integer lastDay = Month.lastDay(month);
        for (int startDay = 0; startDay < lastDay; startDay++) {
            weekdays.put(startDay + 1, weekday.find(startDay % 7));
        }
    }
}
