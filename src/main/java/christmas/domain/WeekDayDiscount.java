package christmas.domain;

import java.util.Map;

public class WeekDayDiscount {

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isWeekday(calculateDayOfWeek(reserveDate));
    }

    private static Integer calculateDayOfWeek(Integer reserveDate) {
        return reserveDate % DayOfWeek.DAYS_IN_WEEK;
    }

    public static Integer calculate(Map<Menu, Integer> orderItems) {
        return 0;
    }
}
