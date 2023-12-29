package christmas.domain.entity;

public enum DayOfWeek {
    FRIDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    public static final Integer DAYS_IN_WEEK = 7;
    private final Integer value;

    DayOfWeek(Integer value) {
        this.value = value;
    }

    public static boolean isWeekday(Integer day) {
        return !isHoliday(day);
    }

    public static boolean isHoliday(Integer day) {
        Integer dayOfWeek = calculateDayOfWeek(day);
        return dayOfWeek.equals(FRIDAY.value) || dayOfWeek.equals(SATURDAY.value);
    }

    public static boolean isSunday(Integer day) {
        Integer dayOfWeek = calculateDayOfWeek(day);
        return dayOfWeek.equals(SUNDAY.value);
    }

    private static Integer calculateDayOfWeek(Integer reserveDate) {
        return reserveDate % DayOfWeek.DAYS_IN_WEEK;
    }
}