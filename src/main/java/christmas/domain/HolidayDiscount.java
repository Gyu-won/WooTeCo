package christmas.domain;

public class HolidayDiscount {
    public static boolean isWithinPeriod(Integer reserveDate) {
        return DayOfWeek.isHoliday(reserveDate);
    }
}
