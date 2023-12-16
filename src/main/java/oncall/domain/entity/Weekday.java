package oncall.domain.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import oncall.view.message.Error;

public class Weekday {
    private List<String> weekdays = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    public Weekday(String weekday) {
        checkIsContain(weekday);
        while (!weekdays.get(0).equals(weekday)) {
            Collections.rotate(weekdays, -1);
        }
    }

    private void checkIsContain(String weekday) {
        if (!weekdays.contains(weekday)) {
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
    }

    public String find(int index) {
        return weekdays.get(index);
    }
}
