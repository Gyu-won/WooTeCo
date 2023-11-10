package christmas.domain;

public class WeekDayDiscount {

    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isWeekday(calculateDayOfWeek(reserveDate));
    }

    private static Integer calculateDayOfWeek(Integer reserveDate) {
        return reserveDate % DayOfWeek.DAYS_IN_WEEK;
    }

}
