package menu.domain.entity;

import java.util.ArrayList;
import java.util.List;

public enum Weekday {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Weekday(String name) {
        this.name = name;
    }

    public static List<String> getAllName() {
        List<String> weekdayNames = new ArrayList<>();
        for (Weekday weekday : Weekday.values()) {
            weekdayNames.add(weekday.name);
        }
        return weekdayNames;
    }
}
