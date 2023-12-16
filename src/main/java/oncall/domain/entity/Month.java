package oncall.domain.entity;

import java.util.HashMap;
import java.util.Map;

public class Month {
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
}
