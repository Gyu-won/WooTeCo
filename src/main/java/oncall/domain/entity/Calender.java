package oncall.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class Calender {
    private final Integer month;
    private final Map<Integer, String> weekdays = new HashMap<>();

    public Calender(Integer month, Weekday weekday) {
        this.month = month;
        create(month, weekday);
    }

    private void create(Integer month, Weekday weekday) {
        Integer lastDay = Month.lastDay(month);
        for (int startDay = 1; startDay <= lastDay; startDay++) {
            weekdays.put(startDay, weekday.find(startDay % 7 - 1));
        }
    }
}
