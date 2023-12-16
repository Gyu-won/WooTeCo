package oncall.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Month {
    private static final Map<Integer, List<Integer>> holidays = Map.of(
            1, List.of(1),
            3, List.of(1),
            5, List.of(5),
            6, List.of(6),
            8, List.of(15),
            10, List.of(3, 9),
            12, List.of(25)
    );
    private static final Map<Integer, Integer> lastDay = new HashMap<>();

    static {
        lastDay.put(1, 31);
        lastDay.put(2, 28);
        lastDay.put(3, 31);
        lastDay.put(4, 30);
        lastDay.put(5, 31);
        lastDay.put(6, 30);
        lastDay.put(7, 31);
        lastDay.put(8, 31);
        lastDay.put(9, 30);
        lastDay.put(10, 31);
        lastDay.put(11, 30);
        lastDay.put(12, 31);
    }

    public static boolean isExist(Integer parsedMonth) {
        return lastDay.containsKey(parsedMonth);
    }

    public static Integer lastDay(Integer month) {
        return lastDay.get(month);
    }

    public static boolean isHoliday(Integer month, int day) {
        if (holidays.containsKey(month)) {
            List<Integer> holiday = holidays.get(month);
            return holiday.contains(day);
        }
        return false;
    }
}
