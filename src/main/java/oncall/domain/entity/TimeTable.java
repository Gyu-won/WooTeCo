package oncall.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {
    private static final List<String> timeTable = new ArrayList<>();

    public static void add(String worker) {
        timeTable.add(worker);
    }

    public static boolean isWorkBefore(String worker) {
        return timeTable.get(timeTable.size() - 1).equals(worker);
    }
}
